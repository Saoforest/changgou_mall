package top.xiaolinz.web.filter;

import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import reactor.core.publisher.Mono;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.RedisUtils;
import top.xiaolinz.web.service.AuthService;

/**
 * @author XiaoLin
 * @date 2022/3/23 16:22
 * @blog https://www.xiaolinz.top/
 * 
 *       全局鉴权过滤器
 **/
@Component
public class OauthFilter implements GlobalFilter, Ordered {

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final ServerHttpRequest request = exchange.getRequest();
        final ServerHttpResponse response = exchange.getResponse();
        // 判断用户的请求是否是登陆请求,如果是,直接放
        final String path = request.getURI().getPath();
        if ("/api/oauth/login".equals(path) || !UrlFilter.hasAuthorize(path)) {
            // 放行
            return chain.filter(exchange);
        }
        // 从cookie中取jti,如果取不到,拒绝访问
        final String jti = this.authService.getJtiFromCookie(request);
        if (StringUtils.isBlank(jti)) {
            // 没有认证 拒绝访问
            final R r = R.error("未被授权,拒绝访问!");
            return this.result(exchange, r, HttpStatus.UNAUTHORIZED);
        }
        // 从redis中取jti的值,如果取不到,拒绝访问
        final String jwt = (String)this.redisUtils.get(jti);
        if (StringUtils.isBlank(jwt)) {
            // 过期
            final R r = R.error("授权已过期!");
            return this.result(exchange, r, HttpStatus.UNAUTHORIZED);
        }
        // 携带令牌,到达微服务
        request.mutate().header("Authorization", "Bearer " + jwt);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    public Mono<Void> result(ServerWebExchange exchange, R r, HttpStatus status) {
        ServerHttpResponse response = exchange.getResponse();
        final JSONObject jsonObject = JSONUtil.parseObj(r);
        byte[] bits = JSONUtil.toJsonStr(jsonObject).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(status);
        // 指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

}

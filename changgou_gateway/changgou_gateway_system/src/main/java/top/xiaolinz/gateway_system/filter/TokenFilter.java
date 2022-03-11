package top.xiaolinz.gateway_system.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common.utils.JwtUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author XiaoLin
 * @date 2022/3/10 09:23
 * @blog https://www.xiaolinz.top/
 *
 * token鉴权
 **/
@Component
public class TokenFilter implements GlobalFilter, Ordered {


	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		final ServerHttpRequest request = exchange.getRequest();

		final ServerHttpResponse response = exchange.getResponse();

		if(request.getURI().getPath().contains("/admin/login")){
			return chain.filter(exchange);
		}

		// 获取头信息
		final HttpHeaders headers = request.getHeaders();
		// 获取token
		final String token = headers.getFirst("token");
		// 判断令牌是否存在
		if (StringUtils.isEmpty(token)){
			return result(exchange,R.error(StatusCode.ERROR,"令牌为空!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}

		final boolean b = JwtUtil.verifyJWT(token);

		if (b) {
		    return chain.filter(exchange);
		}else {
			return result(exchange,R.error(StatusCode.ERROR,"验证失败!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}

	public Mono<Void> result(ServerWebExchange exchange, R r,HttpStatus status){
		ServerHttpResponse response = exchange.getResponse();
		final JSONObject jsonObject = JSONUtil.parseObj(r);
		byte[] bits = JSONUtil.toJsonStr(jsonObject).getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = response.bufferFactory().wrap(bits);
		response.setStatusCode(status);
		//指定编码，否则在浏览器中会中文乱码
		response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
		return response.writeWith(Mono.just(buffer));
	}
}

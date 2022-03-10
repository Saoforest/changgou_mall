package top.xiaolinz.gateway_system.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common.utils.JwtUtil;

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
			throw new BusinessException("令牌不存在", StatusCode.LOGINERROR);
		}

		final boolean b = JwtUtil.verifyJWT(token);

		if (b) {
		    return chain.filter(exchange);
		}else {
			throw new BusinessException("认证失败", StatusCode.LOGINERROR);
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}
}

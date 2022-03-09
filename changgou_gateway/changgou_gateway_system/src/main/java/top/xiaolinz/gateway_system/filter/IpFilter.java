package top.xiaolinz.gateway_system.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @author XiaoLin
 * @date 2022/3/9 16:19
 * @blog https://www.xiaolinz.top/
 **/
@Component
@Slf4j
public class IpFilter implements GlobalFilter, Ordered {

	/**
	 * 过滤器工鞥
	 * @param exchange
	 * @param chain
	 * @return
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//获取请求的客户端的ip
		log.info("这是第一个过滤器");

		final ServerHttpRequest request = exchange.getRequest();

		final InetSocketAddress address = request.getRemoteAddress();
		final String name = address.getHostName();
		log.info(name);


		return chain.filter(exchange); //放行
	}

	/**
	 * 过滤器顺序
	 * @return
	 */
	@Override
	public int getOrder() {
		return 1;
	}
}

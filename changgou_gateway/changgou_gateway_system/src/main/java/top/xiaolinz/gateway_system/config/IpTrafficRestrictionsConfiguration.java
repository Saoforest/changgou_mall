package top.xiaolinz.gateway_system.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author XiaoLin
 * @date 2022/3/9 16:38
 * @blog https://www.xiaolinz.top/
 *
 * 限流配置类
 **/
@Configuration
public class IpTrafficRestrictionsConfiguration {

	// 生成用于限流的key
	@Bean
	public KeyResolver ipKeyResolver(){

		return new KeyResolver(){
			@Override
			public Mono<String> resolve(ServerWebExchange exchange) {
				return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
			}
		};
	}
}

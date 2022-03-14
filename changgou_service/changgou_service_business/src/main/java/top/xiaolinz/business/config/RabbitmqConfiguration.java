package top.xiaolinz.business.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoLin
 * @date 2022/3/14 19:19
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
public class RabbitmqConfiguration {


	@Bean
	public Queue queue(){
		return QueueBuilder.durable("ad_update_queue").build();
	}
}

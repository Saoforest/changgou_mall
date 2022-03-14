package top.xiaolinz.canal.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoLin
 * @date 2022/3/14 12:52
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
public class RabbitmqConfiguration {

	public static final String AD_UPDATE_QUEUE = "ad_update_queue";

	//上架队列
	public static final String GOODS_UP_QUEUE = "search_add_queue";

	// 定义商品上架交换机
	public static final String GOODS_UP_EXCHANGE = "goods_up_exchange";


	//创建队列
	@Bean(AD_UPDATE_QUEUE)
	public Queue adQueue(){
		return QueueBuilder.durable(AD_UPDATE_QUEUE).build();
	}

	@Bean(GOODS_UP_QUEUE)
	public Queue goodsUpQueue(){
		return QueueBuilder.durable(GOODS_UP_QUEUE).build();
	}

	@Bean(GOODS_UP_EXCHANGE)
	public Exchange goodsUpExchange(){
		return ExchangeBuilder.fanoutExchange(GOODS_UP_EXCHANGE).durable(true).build();
	}

	@Bean
	public Binding goodsUpBinding(@Qualifier(GOODS_UP_QUEUE) Queue queue,@Qualifier(GOODS_UP_EXCHANGE) Exchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with("").noargs();
	}


}

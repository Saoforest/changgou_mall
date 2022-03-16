package top.xiaolinz.canal.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import top.xiaolinz.common.constant.RabbitmqConstant;

/**
 * @author XiaoLin
 * @date 2022/3/14 12:52
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
public class RabbitmqConfiguration {



	//创建队列
    @Bean(RabbitmqConstant.AD_UPDATE_QUEUE)
	public Queue adQueue(){
        return QueueBuilder.durable(RabbitmqConstant.AD_UPDATE_QUEUE).build();
	}

    @Bean(RabbitmqConstant.GOODS_UP_QUEUE)
	public Queue goodsUpQueue(){
        return QueueBuilder.durable(RabbitmqConstant.GOODS_UP_QUEUE).build();
	}

    @Bean(RabbitmqConstant.GOODS_UP_EXCHANGE)
	public Exchange goodsUpExchange(){
        return ExchangeBuilder.fanoutExchange(RabbitmqConstant.GOODS_UP_EXCHANGE).durable(true).build();
	}

	@Bean
    public Binding goodsUpBinding(@Qualifier(RabbitmqConstant.GOODS_UP_QUEUE) Queue queue,
        @Qualifier(RabbitmqConstant.GOODS_UP_EXCHANGE) Exchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("").noargs();
	}

    @Bean(RabbitmqConstant.GOODS_DOWN_QUEUE)
    public Queue goodsDownQueue() {
        return QueueBuilder.durable(RabbitmqConstant.GOODS_DOWN_QUEUE).build();
    }

    @Bean(RabbitmqConstant.GOODS_DOWN_EXCHANGE)
    public Exchange goodsDownExchange() {
        return ExchangeBuilder.fanoutExchange(RabbitmqConstant.GOODS_DOWN_EXCHANGE).durable(true).build();
    }

    @Bean
    public Binding goodsDownBinding(@Qualifier(RabbitmqConstant.GOODS_DOWN_QUEUE) Queue queue,
        @Qualifier(RabbitmqConstant.GOODS_DOWN_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

}

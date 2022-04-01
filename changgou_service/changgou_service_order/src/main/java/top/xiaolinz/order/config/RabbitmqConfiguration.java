package top.xiaolinz.order.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author XiaoLin
 * @date 2022/3/31 19:58
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
public class RabbitmqConfiguration {

    //添加积分任务交换机
    public static final String EX_BUYING_ADDPOINTUSER = "ex_buying_addpointuser";

    //添加积分消息队列
    public static final String CG_BUYING_ADDPOINT = "cg_buying_addpoint";

    //完成添加积分消息队列
    public static final String CG_BUYING_FINISHADDPOINT = "cg_buying_finishaddpoint";

    //添加积分路由key
    public static final String CG_BUYING_ADDPOINT_KEY = "addpoint";

    //完成添加积分路由key
    public static final String CG_BUYING_FINISHADDPOINT_KEY = "finishaddpoint";

    //添加积分队列
    @Bean(CG_BUYING_ADDPOINT)
    public Queue addIntegralQueue() {
        return QueueBuilder.durable(CG_BUYING_ADDPOINT).build();
    }

    //完成添加积分队列
    @Bean(CG_BUYING_FINISHADDPOINT)
    public Queue finishAddIntegralQueue() {
        return QueueBuilder.durable(CG_BUYING_FINISHADDPOINT).build();
    }

    //添加积分交换机
    @Bean(EX_BUYING_ADDPOINTUSER)
    public Exchange addIntegralExchange() {
        return ExchangeBuilder.directExchange(EX_BUYING_ADDPOINTUSER).durable(true).build();
    }

    //绑定添加积分队列到交换机
    @Bean
    public Binding addIntegralBinding(@Qualifier(CG_BUYING_ADDPOINT) Queue queue, @Qualifier(EX_BUYING_ADDPOINTUSER) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(CG_BUYING_ADDPOINT_KEY).noargs();
    }

    //绑定完成添加积分队列到交换机
    @Bean
    public Binding finishAddIntegralBinding(@Qualifier(CG_BUYING_FINISHADDPOINT) Queue queue, @Qualifier(EX_BUYING_ADDPOINTUSER) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(CG_BUYING_FINISHADDPOINT_KEY).noargs();
    }
}

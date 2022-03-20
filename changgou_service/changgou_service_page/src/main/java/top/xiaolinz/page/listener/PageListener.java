package top.xiaolinz.page.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import top.xiaolinz.common.constant.RabbitmqConstant;

/**
 * @author XiaoLin
 * @date 2022/3/18 17:55
 * @blog https://www.xiaolinz.top/
 **/
@Component
@Slf4j
public class PageListener {

    @RabbitListener(
        bindings = @QueueBinding(value = @Queue(value = RabbitmqConstant.PAGE_CREATE_QUEUE, durable = "true"),
            exchange = @Exchange(value = RabbitmqConstant.GOODS_UP_EXCHANGE, durable = "true"), key = ""))
    public void pageCreateMessage(@Payload String spuId) {
        log.info("接收到商品审核消息:生成目标spu的详情页面,spuId:{}", spuId);

    }
}

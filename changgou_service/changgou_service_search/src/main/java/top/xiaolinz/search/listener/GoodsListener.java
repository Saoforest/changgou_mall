package top.xiaolinz.search.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import top.xiaolinz.common.constant.RabbitmqConstant;
import top.xiaolinz.search.service.EsManagerService;

/**
 * @author XiaoLin
 * @date 2022/3/15 21:54
 * @blog https://www.xiaolinz.top/
 **/
@Component
@Slf4j
public class GoodsListener {

    @Autowired
    private EsManagerService esManagerService;

    @RabbitListener(queues = RabbitmqConstant.GOODS_UP_QUEUE)
    public void goodsUp(Message message, @Payload String spuId) {

        log.info("检测到商品上架消息,开始执行检索并导入es,spuId:{}", spuId);

        this.esManagerService.importBySpuId(spuId);
    }

    @RabbitListener(
        bindings = {@QueueBinding(value = @Queue(value = RabbitmqConstant.GOODS_DOWN_QUEUE, durable = "true"),
            exchange = @Exchange(value = RabbitmqConstant.GOODS_DOWN_EXCHANGE, durable = "true"), key = "")})
    public void goodsDown(@Payload String spuId) {
        log.info("检测到商品下架消息,开始执行检索并导入es,spuId:{}", spuId);
        this.esManagerService.deleteBySpuId(spuId);
    }
}

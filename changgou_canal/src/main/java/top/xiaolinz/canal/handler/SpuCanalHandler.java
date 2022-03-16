package top.xiaolinz.canal.handler;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;
import top.xiaolinz.canal.entity.Spu;
import top.xiaolinz.common.constant.RabbitmqConstant;

/**
 * @author XiaoLin
 * @date 2022/3/14 20:02
 * @blog https://www.xiaolinz.top/
 **/
@Component
@Slf4j
@CanalTable("tb_spu")
public class SpuCanalHandler implements EntryHandler<Spu> {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void update(Spu before, Spu after) {
		log.info("检测到spu数据更新:旧数据{},新数据{}",before,after);
		if ("0".equals(before.getIsMarketable()) && "1".equals(after.getIsMarketable())) {
			log.info("条件判断成功,开始发送消息:{}",after.getId());
            this.rabbitTemplate.convertAndSend(RabbitmqConstant.GOODS_UP_EXCHANGE, "", after.getId());
        }

        if ("1".equals(before.getIsMarketable()) && "0".equals(after.getIsMarketable())) {
            log.info("条件判断成功,开始发送消息:{}", after.getId());
            this.rabbitTemplate.convertAndSend(RabbitmqConstant.GOODS_DOWN_EXCHANGE, "", after.getId());
        }
	}
}

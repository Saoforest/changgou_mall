package top.xiaolinz.canal.handler;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;
import top.xiaolinz.canal.entity.Ad;
import top.xiaolinz.common.constant.RabbitmqConstant;

/**
 * @author XiaoLin
 * @date 2022/3/14 12:34
 * @blog https://www.xiaolinz.top/
 **/
@CanalTable(value = "tb_ad")
@Component
@Slf4j
public class AdCanalHandler implements EntryHandler<Ad> {

	@Autowired
	private RabbitTemplate template;


	@Override
	public void update(Ad before, Ad after) {
		// EntryHandler.super.update(before, after);

		log.info("检测到广告数据更新:旧数据{},新数据{}",before,after);


		//	发送消息
		if ("web_index_lb".equals(after.getPosition())) {
			log.info("条件判断成功,开始发送消息:消息参数为{}",after.getPosition());
			this.template.convertAndSend("", RabbitmqConstant.AD_UPDATE_QUEUE, after.getPosition());
        }
	}

	@Override
	public void insert(Ad ad) {
		EntryHandler.super.insert(ad);
	}
}

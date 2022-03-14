package top.xiaolinz.business.listener;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author XiaoLin
 * @date 2022/3/14 19:22
 * @blog https://www.xiaolinz.top/
 **/
@Component
@Slf4j
public class AdListener {

	@RabbitListener(queues = {"ad_update_queue"})
	public void adMessage(Message message){
		log.info("检测到消息传入{}",message);
		final HashMap<String, Object> map = new HashMap<>();
		map.put("position", Arrays.toString(message.getBody()));
		final String s = HttpUtil.get("http://10.211.55.6:8182/ad_update", map);

		log.info("返回的结果{}",s);
	}
}

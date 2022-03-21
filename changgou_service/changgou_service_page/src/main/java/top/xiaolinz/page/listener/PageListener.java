package top.xiaolinz.page.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import top.xiaolinz.common.constant.RabbitmqConstant;
import top.xiaolinz.page.service.PageService;

/**
 * @author XiaoLin
 * @date 2022/3/18 17:55
 * @blog https://www.xiaolinz.top/
 **/
@Component
@Slf4j
public class PageListener {

    @Autowired
    private PageService pageService;

    @RabbitListener(queues = RabbitmqConstant.PAGE_CREATE_QUEUE)
    public void pageCreateMessage(@Payload String spuId) {
        log.info("接收到商品审核消息:生成目标spu的详情页面,spuId:{}", spuId);
        // 为商品生成页面 sku,spu,categoryFeign
        this.pageService.generateHtml(spuId);
    }
}

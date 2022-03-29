package top.xiaolinz.order_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import top.xiaolinz.common.utils.R;
import top.xiaolinz.order_api.entity.Order;

/**
 * @author XiaoLin
 * @date 2022/3/29 00:10
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("order")
public interface OrderFeign {
    @PostMapping("/order/save")
    public R addOrder(@RequestBody Order order);
}

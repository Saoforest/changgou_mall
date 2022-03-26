package top.xiaolinz.order_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/24 15:56
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("order")
public interface CartFeign {

    @GetMapping("/cart/list")
    public R list();

    @PostMapping("/cart/add")
    public R addCart(@RequestParam("skuId") String skuId, @RequestParam("num") Integer num);
}

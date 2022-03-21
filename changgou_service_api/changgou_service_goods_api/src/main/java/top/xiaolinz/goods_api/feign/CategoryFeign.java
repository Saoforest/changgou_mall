package top.xiaolinz.goods_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/20 22:36
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("goods")
public interface CategoryFeign {

    @GetMapping("/category/{CategoryId}")
    public R findById(@PathVariable("CategoryId") Integer categoryId);
}

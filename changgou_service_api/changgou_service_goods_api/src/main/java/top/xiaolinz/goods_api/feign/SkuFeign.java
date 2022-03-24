package top.xiaolinz.goods_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/15 16:22
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("goods")
public interface SkuFeign {

    @GetMapping("/sku/list/{spuId}")
    public R findSkuListBySpuId(@PathVariable("spuId") String spuId);

    @GetMapping("/sku/{skuId}")
    public R findById(@PathVariable("skuId") String skuId);

}

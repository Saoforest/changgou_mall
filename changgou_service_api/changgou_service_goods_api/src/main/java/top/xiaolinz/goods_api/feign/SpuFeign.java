package top.xiaolinz.goods_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/20 22:38
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("goods")
public interface SpuFeign {

    @GetMapping("/spu/find/spu/{spuId}")
    public R findSpuById(@PathVariable("spuId") String spuId);
}

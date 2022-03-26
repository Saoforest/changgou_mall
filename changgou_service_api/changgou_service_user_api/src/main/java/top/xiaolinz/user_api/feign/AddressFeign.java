package top.xiaolinz.user_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/24 22:22
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("user")
public interface AddressFeign {
    @GetMapping("/address/user/list")
    public R findAddress();
}

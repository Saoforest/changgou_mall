package top.xiaolinz.user_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/23 14:42
 * @blog https://www.xiaolinz.top/
 **/
@FeignClient("user")
public interface UserFeign {

    @GetMapping("/user/load/{name}")
    public R findByName(@PathVariable("name") String name);
}

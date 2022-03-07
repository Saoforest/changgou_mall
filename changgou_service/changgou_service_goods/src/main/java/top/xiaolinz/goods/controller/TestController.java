package top.xiaolinz.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xiaolinz.common.utils.R;

/**
 * @author XiaoLin
 * @date 2022/3/6 13:42
 * @blog https://www.xiaolinz.top/
 **/
@RestController
public class TestController {
	@GetMapping("/test")
	public R test(){
		return R.ok();
	}
}

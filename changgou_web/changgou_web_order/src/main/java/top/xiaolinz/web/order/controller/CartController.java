package top.xiaolinz.web.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.hutool.core.lang.TypeReference;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.order_api.feign.CartFeign;

/**
 * @author XiaoLin
 * @date 2022/3/24 16:16
 * @blog https://www.xiaolinz.top/
 **/
@Controller
@RequestMapping("/wcart")
public class CartController {

    @Autowired
    private CartFeign cartFeign;

    @GetMapping("/list")
    public String list(Model model) {
        final R r = this.cartFeign.list();
        final Map<String, Object> data = r.getData("data", new TypeReference<Map<String, Object>>() {});
        model.addAttribute("items", data);
        return "cart";
    }

    @PostMapping("/add")
    @ResponseBody
    public R add(@RequestParam String id, @RequestParam Integer num) {
        this.cartFeign.addCart(id, num);
        final Map<String, Object> data =
            this.cartFeign.list().getData("data", new TypeReference<Map<String, Object>>() {});
        return R.ok(StatusCode.OK, "添加成功").put("data", data);
    }
}

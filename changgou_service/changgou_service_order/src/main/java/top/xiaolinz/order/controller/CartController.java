package top.xiaolinz.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.order_api.service.CartService;

/**
 * @author XiaoLin
 * @date 2022/3/24 00:58
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public R addCart(@RequestParam String skuId, @RequestParam Integer num) {
        String username = "haha";
        this.cartService.addCart(skuId, num, username);

        return R.ok(StatusCode.OK, "添加商品至购物车成功");
    }

    @ApiOperation(value = "获取购物车商品列表")
    @GetMapping("/list")
    public R list() {
        String username = "haha";
        final Map<String, Object> list = this.cartService.getCartList(username);

        return R.ok().put("data", list);
    }
}

package top.xiaolinz.web.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.hutool.core.lang.TypeReference;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.order_api.entity.Order;
import top.xiaolinz.order_api.entity.OrderItem;
import top.xiaolinz.order_api.feign.CartFeign;
import top.xiaolinz.order_api.feign.OrderFeign;
import top.xiaolinz.user_api.entity.Address;
import top.xiaolinz.user_api.feign.AddressFeign;

/**
 * @author XiaoLin
 * @date 2022/3/27 20:15
 * @blog https://www.xiaolinz.top/
 **/
@Controller
@RequestMapping("/worder")
public class OrderController {

    @Autowired
    private AddressFeign addressFeign;

    @Autowired
    private CartFeign cartFeign;

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/ready/order")
    public String readOrder(Model model){

//        获取地址集合信息
        final List<Address> addressList = this.addressFeign.findAddress().getData("data", new TypeReference<List<Address>>() {
        });

//        获取购物车中商品信息
        final Map<String, Object> map =
            this.cartFeign.list().getData("data", new TypeReference<Map<String, Object>>() {
            });

        final List<OrderItem> orderItemList = (List<OrderItem>)map.get("orderItemList");
        final Integer num = (Integer)map.get("totalNum");
        final Integer money = (Integer)map.get("totalMoney");

        model.addAttribute("carts",orderItemList);
        model.addAttribute("totalNum",num);
        model.addAttribute("totalMoney",money);

        model.addAttribute("address",addressList);

//        获取默认信息
        final Address defaultAddress =
            addressList.parallelStream().filter(address -> "1".equals(address.getIsDefault())).findFirst().get();
        model.addAttribute("deAddr",defaultAddress);


        return "order";
    }

    /**
     * 生成订单
     */
    @PostMapping("/add")
    @ResponseBody
    public R addOrder(@RequestBody Order order){
        final R r = this.orderFeign.addOrder(order);
        return r;

    }
}

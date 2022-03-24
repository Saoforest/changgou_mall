package top.xiaolinz.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xiaolinz.common.utils.RedisUtils;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.feign.SkuFeign;
import top.xiaolinz.goods_api.feign.SpuFeign;
import top.xiaolinz.order_api.entity.OrderItem;
import top.xiaolinz.order_api.service.CartService;

/**
 * @author XiaoLin
 * @date 2022/3/23 23:53
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class CartServiceImpl implements CartService {

    public static final String CART = "cart:CART_";
    @Autowired
    private SkuFeign skuFeign;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SpuFeign spuFeign;

    @Override
    public void addCart(String skuId, Integer num, String username) {
        // 购物车已有,更新数量
        OrderItem orderItem = (OrderItem)this.redisUtils.hget(CART + username, skuId);
        if (orderItem != null) {
            orderItem.setNum(orderItem.getNum() + num);
            orderItem.setMoney(orderItem.getPrice() * orderItem.getNum());
            orderItem.setPayMoney(orderItem.getPrice() * orderItem.getNum());
        } else {
            // 不存在,新增商品
            // 获取商品信息
            final Sku sku = this.skuFeign.findById(skuId).getData("data", Sku.class);
            // 获取spu信息
            final Spu spu = this.spuFeign.findSpuById(sku.getSpuId()).getData("data", Spu.class);

            // 封装orderItem
            orderItem = this.goodToOrderItem(sku, spu, num);
        }
        this.redisUtils.hset(CART + username, skuId, orderItem);
    }

    @Override
    public Map<String, Object> getCartList(String username) {
        final HashMap<String, Object> map = new HashMap<>();
        // 统计总数量
        AtomicReference<Integer> totalNum = new AtomicReference<>(0);
        AtomicReference<Integer> totalMoney = new AtomicReference<>(0);
        final List<Object> list = this.redisUtils.hget(CART + username);
        final List<OrderItem> orderItemList = list.parallelStream().map(obj -> {
            final OrderItem item = (OrderItem)obj;
            totalNum.updateAndGet(v -> v + item.getNum());
            totalMoney.updateAndGet(v -> v + item.getMoney());
            return item;
        }).collect(Collectors.toList());

        map.put("orderItemList", orderItemList);
        map.put("totalNum", totalNum.get());
        map.put("totalMoney", totalMoney.get());

        return map;
    }

    /**
     * 封装orderItem
     * 
     * @param sku
     *            sku对象
     * @param spu
     *            spu对象
     * @param num
     *            商品数量
     * @return orderItem对象
     */
    private OrderItem goodToOrderItem(Sku sku, Spu spu, Integer num) {
        final OrderItem item = new OrderItem();
        item.setSpuId(spu.getId());
        item.setSkuId(sku.getId());
        item.setName(sku.getName());
        item.setPrice(sku.getPrice());
        item.setNum(num);
        item.setMoney(item.getPrice() * item.getNum());
        item.setPayMoney(item.getPrice() * item.getNum());
        item.setImage(sku.getImage());
        item.setWeight(sku.getWeight() * item.getNum());

        // 分类信息
        item.setCategoryId1(spu.getCategory1Id());
        item.setCategoryId2(spu.getCategory2Id());
        item.setCategoryId3(spu.getCategory3Id());

        return item;
    }
}

package top.xiaolinz.order_api.service;

import java.util.Map;

/**
 * @author XiaoLin
 * @date 2022/3/23 23:52
 * @blog https://www.xiaolinz.top/
 **/
public interface CartService {
    /**
     * 添加购物车
     * 
     * @param skuId
     *            skuid
     * @param num
     *            数量
     * @param username
     *            用户名(主键)
     */
    void addCart(String skuId, Integer num, String username);

    /**
     * 获取购物车
     * 
     * @param username
     *            用户姓名
     * @return 购物车列表
     */
    Map<String, Object> getCartList(String username);
}

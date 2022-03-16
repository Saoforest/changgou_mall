package top.xiaolinz.common.constant;

/**
 * @author XiaoLin
 * @date 2022/3/15 21:56
 * @blog https://www.xiaolinz.top/
 **/
public class RabbitmqConstant {

    public static final String AD_UPDATE_QUEUE = "ad_update_queue";

    // 上架队列
    public static final String GOODS_UP_QUEUE = "search_add_queue";

    // 定义商品上架交换机
    public static final String GOODS_UP_EXCHANGE = "goods_up_exchange";

    public static final String GOODS_DOWN_QUEUE = "search_delete_queue";

    public static final String GOODS_DOWN_EXCHANGE = "goods_down_exchange";

}

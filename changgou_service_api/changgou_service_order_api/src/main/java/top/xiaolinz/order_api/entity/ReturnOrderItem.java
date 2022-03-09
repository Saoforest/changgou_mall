package top.xiaolinz.order_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_return_order_item")
public class ReturnOrderItem implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 分类ID
     */
    @TableField(value = "category_id")
    private Integer categoryId;

    /**
     * SPU_ID
     */
    @TableField(value = "spu_id")
    private String spuId;

    /**
     * SKU_ID
     */
    @TableField(value = "sku_id")
    private String skuId;

    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;

    /**
     * 订单明细ID
     */
    @TableField(value = "order_item_id")
    private String orderItemId;

    /**
     * 退货订单ID
     */
    @TableField(value = "return_order_id")
    private String returnOrderId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 单价
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 数量
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 总金额
     */
    @TableField(value = "money")
    private Integer money;

    /**
     * 支付金额
     */
    @TableField(value = "pay_money")
    private Integer payMoney;

    /**
     * 图片地址
     */
    @TableField(value = "image")
    private String image;

    /**
     * 重量
     */
    @TableField(value = "weight")
    private Integer weight;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_SPU_ID = "spu_id";

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_RETURN_ORDER_ID = "return_order_id";

    public static final String COL_TITLE = "title";

    public static final String COL_PRICE = "price";

    public static final String COL_NUM = "num";

    public static final String COL_MONEY = "money";

    public static final String COL_PAY_MONEY = "pay_money";

    public static final String COL_IMAGE = "image";

    public static final String COL_WEIGHT = "weight";
}
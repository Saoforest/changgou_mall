package top.xiaolinz.order_api.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName(value = "tb_order_item")
public class OrderItem implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_CATEGORY_ID1 = "category_id1";
    public static final String COL_CATEGORY_ID2 = "category_id2";
    public static final String COL_CATEGORY_ID3 = "category_id3";
    public static final String COL_SPU_ID = "spu_id";
    public static final String COL_SKU_ID = "sku_id";
    public static final String COL_ORDER_ID = "order_id";
    public static final String COL_NAME = "name";
    public static final String COL_PRICE = "price";
    public static final String COL_NUM = "num";
    public static final String COL_MONEY = "money";
    public static final String COL_PAY_MONEY = "pay_money";
    public static final String COL_IMAGE = "image";
    public static final String COL_WEIGHT = "weight";
    public static final String COL_POST_FEE = "post_fee";
    public static final String COL_IS_RETURN = "is_return";
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 1级分类
     */
    @TableField(value = "category_id1")
    private Integer categoryId1;
    /**
     * 2级分类
     */
    @TableField(value = "category_id2")
    private Integer categoryId2;
    /**
     * 3级分类
     */
    @TableField(value = "category_id3")
    private Integer categoryId3;
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
     * 商品名称
     */
    @TableField(value = "`name`")
    private String name;
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
     * 实付金额
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
    /**
     * 运费
     */
    @TableField(value = "post_fee")
    private Integer postFee;
    /**
     * 是否退货
     */
    @TableField(value = "is_return")
    private String isReturn;
}
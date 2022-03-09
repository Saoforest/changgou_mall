package top.xiaolinz.order_api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author XiaoLin
 * @date 2022/3/8 00:05
 * @blog https://www.xiaolinz.top/
 **/
@Data
@ApiModel(value = "分页查询封装类")
public class PageOrderItemRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * ID
	 */
	@ApiModelProperty(value = "id")
	private String id;

	/**
	 * 1级分类
	 */
	@ApiModelProperty(value  = "category_id1")
	private Integer categoryId1;

	/**
	 * 2级分类
	 */
	@ApiModelProperty(value  = "category_id2")
	private Integer categoryId2;

	/**
	 * 3级分类
	 */
	@ApiModelProperty(value  = "category_id3")
	private Integer categoryId3;

	/**
	 * SPU_ID
	 */
	@ApiModelProperty(value  = "spu_id")
	private String spuId;

	/**
	 * SKU_ID
	 */
	@ApiModelProperty(value  = "sku_id")
	private String skuId;

	/**
	 * 订单ID
	 */
	@ApiModelProperty(value  = "order_id")
	private String orderId;

	/**
	 * 商品名称
	 */
	@ApiModelProperty(value  = "`name`")
	private String name;

	/**
	 * 单价
	 */
	@ApiModelProperty(value  = "price")
	private Integer price;

	/**
	 * 数量
	 */
	@ApiModelProperty(value  = "num")
	private Integer num;

	/**
	 * 总金额
	 */
	@ApiModelProperty(value  = "money")
	private Integer money;

	/**
	 * 实付金额
	 */
	@ApiModelProperty(value  = "pay_money")
	private Integer payMoney;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value  = "image")
	private String image;

	/**
	 * 重量
	 */
	@ApiModelProperty(value  = "weight")
	private Integer weight;

	/**
	 * 运费
	 */
	@ApiModelProperty(value  = "post_fee")
	private Integer postFee;

	/**
	 * 是否退货
	 */
	@ApiModelProperty(value  = "is_return")
	private String isReturn;
}

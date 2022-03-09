package top.xiaolinz.order_api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author XiaoLin
 * @date 2022/3/8 00:05
 * @blog https://www.xiaolinz.top/
 **/
@Data
@ApiModel(value = "分页查询封装类")
public class PageReturnOrderItemRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	private String id;

	/**
	 * 分类ID
	 */
	@ApiModelProperty(value = "category_id")
	private Integer categoryId;

	/**
	 * SPU_ID
	 */
	@ApiModelProperty(value = "spu_id")
	private String spuId;

	/**
	 * SKU_ID
	 */
	@ApiModelProperty(value = "sku_id")
	private String skuId;

	/**
	 * 订单ID
	 */
	@ApiModelProperty(value = "order_id")
	private String orderId;

	/**
	 * 订单明细ID
	 */
	@ApiModelProperty(value = "order_item_id")
	private String orderItemId;

	/**
	 * 退货订单ID
	 */
	@ApiModelProperty(value = "return_order_id")
	private String returnOrderId;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "title")
	private String title;

	/**
	 * 单价
	 */
	@ApiModelProperty(value = "price")
	private Integer price;

	/**
	 * 数量
	 */
	@ApiModelProperty(value = "num")
	private Integer num;

	/**
	 * 总金额
	 */
	@ApiModelProperty(value = "money")
	private Integer money;

	/**
	 * 支付金额
	 */
	@ApiModelProperty(value = "pay_money")
	private Integer payMoney;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value = "image")
	private String image;

	/**
	 * 重量
	 */
	@ApiModelProperty(value = "weight")
	private Integer weight;
}

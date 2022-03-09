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
public class PageOrderRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 订单id
	 */
	@ApiModelProperty(value = "ID")
	private String id;

	/**
	 * 数量合计
	 */
	@ApiModelProperty(value = "total_num")
	private Integer totalNum;

	/**
	 * 金额合计
	 */
	@ApiModelProperty(value = "total_money")
	private Integer totalMoney;

	/**
	 * 优惠金额
	 */
	@ApiModelProperty(value = "pre_money")
	private Integer preMoney;

	/**
	 * 邮费
	 */
	@ApiModelProperty(value = "post_fee")
	private Integer postFee;

	/**
	 * 实付金额
	 */
	@ApiModelProperty(value = "pay_money")
	private Integer payMoney;

	/**
	 * 支付类型，1、在线支付、0 货到付款
	 */
	@ApiModelProperty(value = "pay_type")
	private String payType;

	/**
	 * 订单创建时间
	 */
	@ApiModelProperty(value = "create_time")
	private Date createTime;

	/**
	 * 订单更新时间
	 */
	@ApiModelProperty(value = "update_time")
	private Date updateTime;

	/**
	 * 付款时间
	 */
	@ApiModelProperty(value = "pay_time")
	private Date payTime;

	/**
	 * 发货时间
	 */
	@ApiModelProperty(value = "consign_time")
	private Date consignTime;

	/**
	 * 交易完成时间
	 */
	@ApiModelProperty(value = "end_time")
	private Date endTime;

	/**
	 * 交易关闭时间
	 */
	@ApiModelProperty(value = "close_time")
	private Date closeTime;

	/**
	 * 物流名称
	 */
	@ApiModelProperty(value = "shipping_name")
	private String shippingName;

	/**
	 * 物流单号
	 */
	@ApiModelProperty(value = "shipping_code")
	private String shippingCode;

	/**
	 * 用户名称
	 */
	@ApiModelProperty(value = "username")
	private String username;

	/**
	 * 买家留言
	 */
	@ApiModelProperty(value = "buyer_message")
	private String buyerMessage;

	/**
	 * 是否评价
	 */
	@ApiModelProperty(value = "buyer_rate")
	private String buyerRate;

	/**
	 * 收货人
	 */
	@ApiModelProperty(value = "receiver_contact")
	private String receiverContact;

	/**
	 * 收货人手机
	 */
	@ApiModelProperty(value = "receiver_mobile")
	private String receiverMobile;

	/**
	 * 收货人地址
	 */
	@ApiModelProperty(value = "receiver_address")
	private String receiverAddress;

	/**
	 * 订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面
	 */
	@ApiModelProperty(value = "source_type")
	private String sourceType;

	/**
	 * 交易流水号
	 */
	@ApiModelProperty(value = "transaction_id")
	private String transactionId;

	/**
	 * 订单状态 
	 */
	@ApiModelProperty(value = "order_status")
	private String orderStatus;

	/**
	 * 支付状态 0:未支付 1:已支付
	 */
	@ApiModelProperty(value = "pay_status")
	private String payStatus;

	/**
	 * 发货状态 0:未发货 1:已发货 2:已送达
	 */
	@ApiModelProperty(value = "consign_status")
	private String consignStatus;

	/**
	 * 是否删除
	 */
	@ApiModelProperty(value = "is_delete")
	private String isDelete;
}

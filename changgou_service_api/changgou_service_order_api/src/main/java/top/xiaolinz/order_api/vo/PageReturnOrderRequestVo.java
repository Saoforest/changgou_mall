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
public class PageReturnOrderRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 服务单号
	 */
	@ApiModelProperty(value = "ID")
	private String id;

	/**
	 * 订单号
	 */
	@ApiModelProperty(value = "order_id")
	private Long orderId;

	/**
	 * 申请时间
	 */
	@ApiModelProperty(value = "apply_time")
	private Date applyTime;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "user_id")
	private Long userId;

	/**
	 * 用户账号
	 */
	@ApiModelProperty(value = "user_account")
	private String userAccount;

	/**
	 * 联系人
	 */
	@ApiModelProperty(value = "linkman")
	private String linkman;

	/**
	 * 联系人手机
	 */
	@ApiModelProperty(value = "linkman_mobile")
	private String linkmanMobile;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "`type`")
	private String type;

	/**
	 * 退款金额
	 */
	@ApiModelProperty(value = "return_money")
	private Integer returnMoney;

	/**
	 * 是否退运费
	 */
	@ApiModelProperty(value = "is_return_freight")
	private String isReturnFreight;

	/**
	 * 申请状态
	 */
	@ApiModelProperty(value = "`status`")
	private String status;

	/**
	 * 处理时间
	 */
	@ApiModelProperty(value = "dispose_time")
	private Date disposeTime;

	/**
	 * 退货退款原因
	 */
	@ApiModelProperty(value = "return_cause")
	private Integer returnCause;

	/**
	 * 凭证图片
	 */
	@ApiModelProperty(value = "evidence")
	private String evidence;

	/**
	 * 问题描述
	 */
	@ApiModelProperty(value = "description")
	private String description;

	/**
	 * 处理备注
	 */
	@ApiModelProperty(value = "remark")
	private String remark;

	/**
	 * 管理员id
	 */
	@ApiModelProperty(value = "admin_id")
	private Integer adminId;
}

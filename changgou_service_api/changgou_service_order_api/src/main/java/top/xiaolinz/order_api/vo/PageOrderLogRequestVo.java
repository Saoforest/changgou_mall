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
public class PageOrderLogRequestVo {
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
	 * 操作员
	 */
	@ApiModelProperty(value= "operater")
	private String operater;

	/**
	 * 操作时间
	 */
	@ApiModelProperty(value= "operate_time")
	private Date operateTime;

	/**
	 * 订单ID
	 */
	@ApiModelProperty(value= "order_id")
	private Long orderId;

	/**
	 * 订单状态
	 */
	@ApiModelProperty(value= "order_status")
	private String orderStatus;

	/**
	 * 付款状态
	 */
	@ApiModelProperty(value= "pay_status")
	private String payStatus;

	/**
	 * 发货状态
	 */
	@ApiModelProperty(value= "consign_status")
	private String consignStatus;

	/**
	 * 备注
	 */
	@ApiModelProperty(value= "remarks")
	private String remarks;
}

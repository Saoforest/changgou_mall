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
public class PagePreferentialRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * ID
	 */
	@ApiModelProperty(value = "id")
	private Integer id;

	/**
	 * 消费金额
	 */
	@ApiModelProperty(value = "buy_money")
	private Integer buyMoney;

	/**
	 * 优惠金额
	 */
	@ApiModelProperty(value = "pre_money")
	private Integer preMoney;

	/**
	 * 品类ID
	 */
	@ApiModelProperty(value = "category_id")
	private Integer categoryId;

	/**
	 * 活动开始日期
	 */
	@ApiModelProperty(value = "start_time")
	private Date startTime;

	/**
	 * 活动截至日期
	 */
	@ApiModelProperty(value = "end_time")
	private Date endTime;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "`state`")
	private String state;

	/**
	 * 类型1不翻倍 2翻倍
	 */
	@ApiModelProperty(value = "`type`")
	private String type;
}

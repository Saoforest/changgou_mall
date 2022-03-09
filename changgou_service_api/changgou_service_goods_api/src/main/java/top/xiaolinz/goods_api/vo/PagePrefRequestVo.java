package top.xiaolinz.goods_api.vo;

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
public class PagePrefRequestVo {
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
	 * 分类ID
	 */
	@ApiModelProperty(value = "分类id")
	private Integer cateId;

	/**
	 * 消费金额
	 */
	@ApiModelProperty(value = "消费金额")
	private Integer buyMoney;

	/**
	 * 优惠金额
	 */
	@ApiModelProperty(value = "优惠金额")
	private Integer preMoney;

	/**
	 * 活动开始日期
	 */
	@ApiModelProperty(value = "活动开始日期")
	private Date startTime;

	/**
	 * 活动截至日期
	 */
	@ApiModelProperty(value = "活动截止日期")
	private Date endTime;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型")
	private String type;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private String state;
}

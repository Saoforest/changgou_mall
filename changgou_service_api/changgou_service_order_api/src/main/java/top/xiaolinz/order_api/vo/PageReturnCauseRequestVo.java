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
public class PageReturnCauseRequestVo {
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
	 * 原因
	 */
	@ApiModelProperty(value = "cause")
	private String cause;

	/**
	 * 排序
	 */
	@ApiModelProperty(value = "seq")
	private Integer seq;

	/**
	 * 是否启用
	 */
	@ApiModelProperty(value = "`status`")
	private String status;
}

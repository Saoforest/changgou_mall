package top.xiaolinz.goods_api.vo;

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
public class PageTemplateRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	private Integer id;

	/**
	 * 模板名称
	 */
	@ApiModelProperty(value = "模板名称")
	private String name;

	/**
	 * 规格数量
	 */
	@ApiModelProperty(value = "规格数量")
	private Integer specNum;

	/**
	 * 参数数量
	 */
	@ApiModelProperty(value = "参数数量")
	private Integer paraNum;
}

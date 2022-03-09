package top.xiaolinz.system_api.vo;

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
public class PageMenuRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;

	/**
	 * 菜单ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private String id;

	/**
	 * 菜单名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 图标
	 */
	@TableField(value = "icon")
	private String icon;

	/**
	 * URL
	 */
	@TableField(value = "url")
	private String url;

	/**
	 * 上级菜单ID
	 */
	@TableField(value = "parent_id")
	private String parentId;
}

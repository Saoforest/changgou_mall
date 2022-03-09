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
public class PageCategoryRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 分类ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "分类id")
	private Integer id;

	/**
	 * 分类名称
	 */
	@TableField(value = "`name`")
	@ApiModelProperty(value = "分类名称")
	private String name;

	/**
	 * 商品数量
	 */
	@TableField(value = "goods_num")
	@ApiModelProperty(value = "商品数量")
	private Integer goodsNum;

	/**
	 * 是否显示
	 */
	@TableField(value = "is_show")
	@ApiModelProperty(value = "是否显示")
	private String isShow;

	/**
	 * 是否导航
	 */
	@TableField(value = "is_menu")
	@ApiModelProperty(value = "是否导航")
	private String isMenu;

	/**
	 * 排序
	 */
	@TableField(value = "seq")
	@ApiModelProperty(value = "排序")
	private Integer seq;

	/**
	 * 上级ID
	 */
	@TableField(value = "parent_id")
	@ApiModelProperty(value = "上级id")
	private Integer parentId;

	/**
	 * 模板ID
	 */
	@TableField(value = "template_id")
	@ApiModelProperty(value = "模板id")
	private Integer templateId;
}

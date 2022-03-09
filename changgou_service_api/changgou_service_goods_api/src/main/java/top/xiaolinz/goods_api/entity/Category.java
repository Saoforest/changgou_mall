package top.xiaolinz.goods_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.xiaolinz.common.group.UpdateGroup;

import javax.validation.constraints.NotNull;

/**
* 
* @author XiaoLin
* @date 2022/3/7 00:17
* @blog https://www.xiaolinz.top/
* 
**/

/**
 * 商品类目
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_category")
public class Category implements Serializable {
	/**
	 * 分类ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@NotNull(message = "id必须有值!",groups = {UpdateGroup.class})
	private Integer id;

	/**
	 * 分类名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 商品数量
	 */
	@TableField(value = "goods_num")
	private Integer goodsNum;

	/**
	 * 是否显示
	 */
	@TableField(value = "is_show")
	private String isShow;

	/**
	 * 是否导航
	 */
	@TableField(value = "is_menu")
	private String isMenu;

	/**
	 * 排序
	 */
	@TableField(value = "seq")
	private Integer seq;

	/**
	 * 上级ID
	 */
	@TableField(value = "parent_id")
	private Integer parentId;

	/**
	 * 模板ID
	 */
	@TableField(value = "template_id")
	private Integer templateId;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_NAME = "name";

	public static final String COL_GOODS_NUM = "goods_num";

	public static final String COL_IS_SHOW = "is_show";

	public static final String COL_IS_MENU = "is_menu";

	public static final String COL_SEQ = "seq";

	public static final String COL_PARENT_ID = "parent_id";

	public static final String COL_TEMPLATE_ID = "template_id";
}
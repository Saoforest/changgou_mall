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
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_album")
public class Album implements Serializable {
	/**
	 * 编号
	 */
	@NotNull(message = "id不能为空!",groups = UpdateGroup.class)
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 相册名称
	 */
	@TableField(value = "title")
	private String title;

	/**
	 * 相册封面
	 */
	@TableField(value = "image")
	private String image;

	/**
	 * 图片列表
	 */
	@TableField(value = "image_items")
	private String imageItems;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_TITLE = "title";

	public static final String COL_IMAGE = "image";

	public static final String COL_IMAGE_ITEMS = "image_items";
}
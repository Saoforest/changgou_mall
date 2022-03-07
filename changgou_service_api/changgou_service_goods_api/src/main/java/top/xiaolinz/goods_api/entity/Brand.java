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

/**
* 
* @author XiaoLin
* @date 2022/3/7 00:17
* @blog https://www.xiaolinz.top/
* 
**/

/**
 * 品牌表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_brand")
public class Brand implements Serializable {
	/**
	 * 品牌id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 品牌名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 品牌图片地址
	 */
	@TableField(value = "image")
	private String image;

	/**
	 * 品牌的首字母
	 */
	@TableField(value = "letter")
	private String letter;

	/**
	 * 排序
	 */
	@TableField(value = "seq")
	private Integer seq;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_NAME = "name";

	public static final String COL_IMAGE = "image";

	public static final String COL_LETTER = "letter";

	public static final String COL_SEQ = "seq";
}
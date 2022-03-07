package top.xiaolinz.goods_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
 * 品牌表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_brand")
@ApiModel
public class Brand implements Serializable {
	/**
	 * 品牌id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@NotNull(message = "id必须有值!",groups = {UpdateGroup.class})
	@ApiModelProperty(value = "品牌id")
	private Integer id;

	/**
	 * 品牌名称
	 */
	@TableField(value = "`name`")
	@ApiModelProperty(value = "品牌名字")
	private String name;

	/**
	 * 品牌图片地址
	 */
	@TableField(value = "image")
	@ApiModelProperty(value = "品牌图片地址")
	private String image;

	/**
	 * 品牌的首字母
	 */
	@TableField(value = "letter")
	@ApiModelProperty(value = "品牌首字母")
	private String letter;

	/**
	 * 排序
	 */
	@TableField(value = "seq")
	@ApiModelProperty(value = "品牌排序字段")
	private Integer seq;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_NAME = "name";

	public static final String COL_IMAGE = "image";

	public static final String COL_LETTER = "letter";

	public static final String COL_SEQ = "seq";
}
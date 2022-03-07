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
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_template")
public class Template implements Serializable {
	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 模板名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 规格数量
	 */
	@TableField(value = "spec_num")
	private Integer specNum;

	/**
	 * 参数数量
	 */
	@TableField(value = "para_num")
	private Integer paraNum;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_NAME = "name";

	public static final String COL_SPEC_NUM = "spec_num";

	public static final String COL_PARA_NUM = "para_num";
}
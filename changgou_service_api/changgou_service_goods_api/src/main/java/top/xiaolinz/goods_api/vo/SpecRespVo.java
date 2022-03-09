package top.xiaolinz.goods_api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 14:59
 * @blog https://www.xiaolinz.top/
 **/
@Data
// @Builder
public class SpecRespVo {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 规格选项
	 */
	private List<String> options;

	/**
	 * 排序
	 */
	private Integer seq;

	/**
	 * 模板ID
	 */
	private Integer templateId;
}

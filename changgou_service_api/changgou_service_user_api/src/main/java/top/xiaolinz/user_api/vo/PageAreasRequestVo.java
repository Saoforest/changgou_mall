package top.xiaolinz.user_api.vo;

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
public class PageAreasRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 区域ID
	 */
	@TableId(value = "areaid", type = IdType.AUTO)
	private String areaid;

	/**
	 * 区域名称
	 */
	@TableField(value = "area")
	private String area;

	/**
	 * 城市ID
	 */
	@TableField(value = "cityid")
	private String cityid;
}

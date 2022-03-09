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
public class PageCitiesRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 城市ID
	 */
	@TableId(value = "cityid", type = IdType.AUTO)
	private String cityid;

	/**
	 * 城市名称
	 */
	@TableField(value = "city")
	private String city;

	/**
	 * 省份ID
	 */
	@TableField(value = "provinceid")
	private String provinceid;
}

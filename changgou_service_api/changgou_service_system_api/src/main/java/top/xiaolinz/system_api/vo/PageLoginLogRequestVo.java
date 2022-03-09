package top.xiaolinz.system_api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author XiaoLin
 * @date 2022/3/8 00:05
 * @blog https://www.xiaolinz.top/
 **/
@Data
@ApiModel(value = "分页查询封装类")
public class PageLoginLogRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	@ApiModelProperty(value = "ID")
	private Integer id;

	@TableField(value = "login_name")
	private String loginName;

	@TableField(value = "ip")
	private String ip;

	@TableField(value = "browser_name")
	private String browserName;

	/**
	 * 地区
	 */
	@TableField(value = "`location`")
	private String location;

	/**
	 * 登录时间
	 */
	@TableField(value = "login_time")
	private Date loginTime;
}

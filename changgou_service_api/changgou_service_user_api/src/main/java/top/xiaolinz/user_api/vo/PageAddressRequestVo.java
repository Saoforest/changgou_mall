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
public class PageAddressRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户名
	 */
	@TableField(value = "username")
	private String username;

	/**
	 * 省
	 */
	@TableField(value = "provinceid")
	private String provinceid;

	/**
	 * 市
	 */
	@TableField(value = "cityid")
	private String cityid;

	/**
	 * 县/区
	 */
	@TableField(value = "areaid")
	private String areaid;

	/**
	 * 电话
	 */
	@TableField(value = "phone")
	private String phone;

	/**
	 * 详细地址
	 */
	@TableField(value = "address")
	private String address;

	/**
	 * 联系人
	 */
	@TableField(value = "contact")
	private String contact;

	/**
	 * 是否是默认 1默认 0否
	 */
	@TableField(value = "is_default")
	private String isDefault;

	/**
	 * 别名
	 */
	@TableField(value = "`alias`")
	private String alias;
}

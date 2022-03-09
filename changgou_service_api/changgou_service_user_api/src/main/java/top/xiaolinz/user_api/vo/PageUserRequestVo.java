package top.xiaolinz.user_api.vo;

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
public class PageUserRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 用户名
	 */
	@TableId(value = "username", type = IdType.AUTO)
	private String username;

	/**
	 * 密码，加密存储
	 */
	@TableField(value = "`password`")
	private String password;

	/**
	 * 注册手机号
	 */
	@TableField(value = "phone")
	private String phone;

	/**
	 * 注册邮箱
	 */
	@TableField(value = "email")
	private String email;

	/**
	 * 创建时间
	 */
	@TableField(value = "created")
	private Date created;

	/**
	 * 修改时间
	 */
	@TableField(value = "updated")
	private Date updated;

	/**
	 * 会员来源：1:PC，2：H5，3：Android，4：IOS
	 */
	@TableField(value = "source_type")
	private String sourceType;

	/**
	 * 昵称
	 */
	@TableField(value = "nick_name")
	private String nickName;

	/**
	 * 真实姓名
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 使用状态（1正常 0非正常）
	 */
	@TableField(value = "`status`")
	private String status;

	/**
	 * 头像地址
	 */
	@TableField(value = "head_pic")
	private String headPic;

	/**
	 * QQ号码
	 */
	@TableField(value = "qq")
	private String qq;

	/**
	 * 手机是否验证 （0否  1是）
	 */
	@TableField(value = "is_mobile_check")
	private String isMobileCheck;

	/**
	 * 邮箱是否检测（0否  1是）
	 */
	@TableField(value = "is_email_check")
	private String isEmailCheck;

	/**
	 * 性别，1男，0女
	 */
	@TableField(value = "sex")
	private String sex;

	/**
	 * 会员等级
	 */
	@TableField(value = "user_level")
	private Integer userLevel;

	/**
	 * 积分
	 */
	@TableField(value = "points")
	private Integer points;

	/**
	 * 经验值
	 */
	@TableField(value = "experience_value")
	private Integer experienceValue;

	/**
	 * 出生年月日
	 */
	@TableField(value = "birthday")
	private Date birthday;

	/**
	 * 最后登录时间
	 */
	@TableField(value = "last_login_time")
	private Date lastLoginTime;
}

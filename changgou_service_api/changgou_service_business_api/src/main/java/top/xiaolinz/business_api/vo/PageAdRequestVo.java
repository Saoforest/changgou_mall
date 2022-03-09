package top.xiaolinz.business_api.vo;

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
public class PageAdRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	private Integer id;

	/**
	 * 广告名称
	 */
	@ApiModelProperty(value = "广告名称")
	private String name;

	/**
	 * 广告位置
	 */
	@ApiModelProperty(value = "广告位值")
	private String position;

	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private Date startTime;

	/**
	 * 到期时间
	 */
	@ApiModelProperty(value = "到期时间")
	private Date endTime;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private String status;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value = "图片地址")
	private String image;

	/**
	 * URL
	 */
	@ApiModelProperty(value = "url")
	private String url;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remarks;
}

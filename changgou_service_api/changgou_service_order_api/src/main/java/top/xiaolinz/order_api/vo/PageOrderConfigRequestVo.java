package top.xiaolinz.order_api.vo;

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
public class PageOrderConfigRequestVo {
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
	 * 正常订单超时时间（分）
	 */
	@ApiModelProperty(value = "order_timeout")
	private Integer orderTimeout;

	/**
	 * 秒杀订单超时时间（分）
	 */
	@ApiModelProperty(value = "seckill_timeout")
	private Integer seckillTimeout;

	/**
	 * 自动收货（天）
	 */
	@ApiModelProperty(value = "take_timeout")
	private Integer takeTimeout;

	/**
	 * 售后期限
	 */
	@ApiModelProperty(value = "service_timeout")
	private Integer serviceTimeout;

	/**
	 * 自动五星好评
	 */
	@ApiModelProperty(value = "comment_timeout")
	private Integer commentTimeout;
}

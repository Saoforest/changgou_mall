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
public class PageUndoLogRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "branch_id")
	private Long branchId;

	@ApiModelProperty(value = "xid")
	private String xid;

	@ApiModelProperty(value = "rollback_info")
	private byte[] rollbackInfo;

	@ApiModelProperty(value = "log_status")
	private Integer logStatus;

	@ApiModelProperty(value = "log_created")
	private Date logCreated;

	@ApiModelProperty(value = "log_modified")
	private Date logModified;

	@ApiModelProperty(value = "ext")
	private String ext;
}

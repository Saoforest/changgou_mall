package top.xiaolinz.goods_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
@TableName(value = "undo_log")
public class UndoLog implements Serializable {
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField(value = "branch_id")
	private Long branchId;

	@TableField(value = "xid")
	private String xid;

	@TableField(value = "rollback_info")
	private byte[] rollbackInfo;

	@TableField(value = "log_status")
	private Integer logStatus;

	@TableField(value = "log_created")
	private Date logCreated;

	@TableField(value = "log_modified")
	private Date logModified;

	@TableField(value = "ext")
	private String ext;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_BRANCH_ID = "branch_id";

	public static final String COL_XID = "xid";

	public static final String COL_ROLLBACK_INFO = "rollback_info";

	public static final String COL_LOG_STATUS = "log_status";

	public static final String COL_LOG_CREATED = "log_created";

	public static final String COL_LOG_MODIFIED = "log_modified";

	public static final String COL_EXT = "ext";
}
package top.xiaolinz.business_api.entity;

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
 * @date 2022/3/8 23:41
 * @blog https://www.xiaolinz.top/
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_activity")
public class Activity implements Serializable {
	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 活动标题
	 */
	@TableField(value = "title")
	private String title;

	/**
	 * 开始时间
	 */
	@TableField(value = "start_time")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@TableField(value = "end_time")
	private Date endTime;

	/**
	 * 状态
	 */
	@TableField(value = "`status`")
	private String status;

	/**
	 * 活动内容
	 */
	@TableField(value = "content")
	private String content;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_TITLE = "title";

	public static final String COL_START_TIME = "start_time";

	public static final String COL_END_TIME = "end_time";

	public static final String COL_STATUS = "status";

	public static final String COL_CONTENT = "content";
}
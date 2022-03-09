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
@TableName(value = "tb_ad")
public class Ad implements Serializable {
	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 广告名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 广告位置
	 */
	@TableField(value = "`position`")
	private String position;

	/**
	 * 开始时间
	 */
	@TableField(value = "start_time")
	private Date startTime;

	/**
	 * 到期时间
	 */
	@TableField(value = "end_time")
	private Date endTime;

	/**
	 * 状态
	 */
	@TableField(value = "`status`")
	private String status;

	/**
	 * 图片地址
	 */
	@TableField(value = "image")
	private String image;

	/**
	 * URL
	 */
	@TableField(value = "url")
	private String url;

	/**
	 * 备注
	 */
	@TableField(value = "remarks")
	private String remarks;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_NAME = "name";

	public static final String COL_POSITION = "position";

	public static final String COL_START_TIME = "start_time";

	public static final String COL_END_TIME = "end_time";

	public static final String COL_STATUS = "status";

	public static final String COL_IMAGE = "image";

	public static final String COL_URL = "url";

	public static final String COL_REMARKS = "remarks";
}
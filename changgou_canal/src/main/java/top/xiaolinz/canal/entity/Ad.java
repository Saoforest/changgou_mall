package top.xiaolinz.canal.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.javatool.canal.client.annotation.CanalTable;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author XiaoLin
 * @date 2022/3/8 23:41
 * @blog https://www.xiaolinz.top/
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ad")
public class Ad implements Serializable {
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 广告名称
	 */
	private String name;

	/**
	 * 广告位置
	 */
	private String position;

	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 到期时间
	 */
	private Date endTime;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 图片地址
	 */
	private String image;

	/**
	 * URL
	 */
	private String url;

	/**
	 * 备注
	 */
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
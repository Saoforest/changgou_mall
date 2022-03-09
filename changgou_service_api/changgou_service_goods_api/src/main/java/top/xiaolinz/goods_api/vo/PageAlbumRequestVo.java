package top.xiaolinz.goods_api.vo;

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
public class PageAlbumRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	private Long id;

	/**
	 * 相册名称
	 */
	@ApiModelProperty(value = "相册名称")
	private String title;

	/**
	 * 相册封面
	 */
	@ApiModelProperty(value = "相册封面")
	private String image;

	/**
	 * 图片列表
	 */
	@ApiModelProperty(value = "图片列表")
	private String imageItems;
}

package top.xiaolinz.system_api.vo;

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
public class PageResourceRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField(value = "res_key")
	private String resKey;

	@TableField(value = "res_name")
	private String resName;

	@TableField(value = "parent_id")
	private Integer parentId;
}

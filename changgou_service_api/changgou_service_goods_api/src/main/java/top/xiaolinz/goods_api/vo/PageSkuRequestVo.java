package top.xiaolinz.goods_api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import io.swagger.annotations.Extension;
import lombok.Data;

import java.util.Date;

/**
 * @author XiaoLin
 * @date 2022/3/8 00:05
 * @blog https://www.xiaolinz.top/
 **/
@Data
@ApiModel(value = "分页查询封装类")
public class PageSkuRequestVo {
	@ApiModelProperty(value = "当前页数")
	private String page;
	@ApiModelProperty(value = "显示个数")
	private String limit;
	/**
	 * 商品id
	 */
	@ApiModelProperty(value = "商品id")
	private String id;

	/**
	 * 商品条码
	 */
	@ApiModelProperty(value = "商品条码")
	private String sn;

	/**
	 * SKU名称
	 */
	@ApiModelProperty(value = "SKU名称")
	private String name;

	/**
	 * 价格（分）
	 */
	@ApiModelProperty(value = "价格(分)")
	private Integer price;

	/**
	 * 库存数量
	 */
	@ApiModelProperty(value = "库存数量")
	private Integer num;

	/**
	 * 库存预警数量
	 */
	@ApiModelProperty(value = "库存预警数量")
	private Integer alertNum;

	/**
	 * 商品图片
	 */
	@ApiModelProperty(value = "商品图片")
	private String image;

	/**
	 * 商品图片列表
	 */
	@ApiModelProperty(value = "商品图片列表")
	private String images;

	/**
	 * 重量（克）
	 */
	@ApiModelProperty(value = "重量(克)")
	private Integer weight;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	/**
	 * SPUID
	 */
	@ApiModelProperty(value = "SPUID")
	private String spuId;

	/**
	 * 类目ID
	 */
	@ApiModelProperty(value = "类目ID")
	private Integer categoryId;

	/**
	 * 类目名称
	 */
	@ApiModelProperty(value = "类目名称")
	private String categoryName;

	/**
	 * 品牌名称
	 */
	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	/**
	 * 规格
	 */
	@ApiModelProperty(value = "规格")
	private String spec;

	/**
	 * 销量
	 */
	@ApiModelProperty(value = "销量")
	private Integer saleNum;

	/**
	 * 评论数
	 */
	@ApiModelProperty(value = "评论数")
	private Integer commentNum;

	/**
	 * 商品状态 1-正常，2-下架，3-删除
	 */
	@ApiModelProperty(value = "商品状态")
	private String status;

	@ApiModelProperty(value = "版本")
	private Integer version;
}

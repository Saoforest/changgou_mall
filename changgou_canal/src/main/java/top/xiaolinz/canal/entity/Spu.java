package top.xiaolinz.canal.entity;

import java.io.Serializable;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_spu")
public class Spu implements Serializable {
	public static final String COL_ID = "id";
	public static final String COL_SN = "sn";
	public static final String COL_NAME = "name";
	public static final String COL_CAPTION = "caption";
	public static final String COL_BRAND_ID = "brand_id";
	public static final String COL_CATEGORY1_ID = "category1_id";
	public static final String COL_CATEGORY2_ID = "category2_id";
	public static final String COL_CATEGORY3_ID = "category3_id";
	public static final String COL_TEMPLATE_ID = "template_id";
	public static final String COL_FREIGHT_ID = "freight_id";
	public static final String COL_IMAGE = "image";
	public static final String COL_IMAGES = "images";
	public static final String COL_SALE_SERVICE = "sale_service";
	public static final String COL_INTRODUCTION = "introduction";
	public static final String COL_SPEC_ITEMS = "spec_items";
	public static final String COL_PARA_ITEMS = "para_items";
	public static final String COL_SALE_NUM = "sale_num";
	public static final String COL_COMMENT_NUM = "comment_num";
	public static final String COL_IS_MARKETABLE = "is_marketable";
	public static final String COL_IS_ENABLE_SPEC = "is_enable_spec";
	public static final String COL_IS_DELETE = "is_delete";
	public static final String COL_STATUS = "status";
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 货号
	 */
	private String sn;
	/**
	 * SPU名
	 */
	private String name;
	/**
	 * 副标题
	 */
	private String caption;
	/**
	 * 品牌ID
	 */
	private Integer brandId;
	/**
	 * 一级分类
	 */
	private Integer category1Id;
	/**
	 * 二级分类
	 */
	private Integer category2Id;
	/**
	 * 三级分类
	 */
	private Integer category3Id;
	/**
	 * 模板ID
	 */
	private Integer templateId;
	/**
	 * 运费模板id
	 */
	private Integer freightId;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 图片列表
	 */
	private String images;
	/**
	 * 售后服务
	 */
	private String saleService;
	/**
	 * 介绍
	 */
	private String introduction;
	/**
	 * 规格列表
	 */
	private String specItems;
	/**
	 * 参数列表
	 */
	private String paraItems;
	/**
	 * 销量
	 */
	private Integer saleNum;
	/**
	 * 评论数
	 */
	private Integer commentNum;
	/**
	 * 是否上架
	 */
	private String isMarketable = "0";
	/**
	 * 是否启用规格
	 */
	private String isEnableSpec;
	/**
	 * 是否删除
	 */
	private String isDelete = "0";
	/**
	 * 审核状态
	 */
	private String status = "0";
}
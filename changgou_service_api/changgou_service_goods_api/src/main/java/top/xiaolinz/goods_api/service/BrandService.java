package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageBrandRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface BrandService extends IService<Brand> {

	/**
	 * 查询所有品牌
	 *
	 * @return 品牌集合
	 */
	List<Brand> findAll();


	/**
	 * 根据id查询对应品牌
	 * @param id 品牌id
	 * @return 品牌对象
	 */
	Brand findBrandById(Integer id);


	/**
	 * 添加品牌
	 * @param brand 品牌信息
	 */
	void addBrand(Brand brand);

	/**
	 * 修改品牌
	 * @param brand 品牌对象
	 */
	void updateBrand(Brand brand);


	/**
	 * 删除品牌
	 * @param id 品牌id
	 */
	void deleteBrand(Integer id);

	/**
	 * 条件查询品牌
	 * @param brand 品牌条件信息
	 * @return 查询到的品牌集
	 */
	List<Brand> findBrandByConditions(Brand brand);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Brand> findByPage(PageBrandRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Brand> findByPageAndCondition(PageBrandRequestVo vo);

	/**
	 * 根据分类名字查询品牌集
	 * @param categoryName 分类名字
	 * @return 品牌集合
	 */
	List<Brand> findBrandListByCategoryName(String categoryName);
}


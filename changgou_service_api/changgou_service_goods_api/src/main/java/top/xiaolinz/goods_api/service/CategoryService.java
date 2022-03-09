package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Category;
import top.xiaolinz.goods_api.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageCategoryRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface CategoryService extends IService<Category> {
	/**
	 * 查询所有品牌
	 *
	 * @return 品牌集合
	 */
	List<Category> findAll();


	/**
	 * 根据id查询对应品牌
	 * @param id 品牌id
	 * @return 品牌对象
	 */
	Category findCategoryById(Integer id);


	/**
	 * 添加数据
	 * @param Category 数据信息
	 */
	void addCategory(Category Category);

	/**
	 * 修改数据
	 * @param Category 数据对象
	 */
	void updateCategory(Category Category);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deleteCategory(Integer id);

	/**
	 * 条件查询数据
	 * @param Category 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Category> findCategoryByConditions(Category Category);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Category> findByPage(PageCategoryRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Category> findByPageAndCondition(PageCategoryRequestVo vo);

}


package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Spec;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageSpecRequestVo;
import top.xiaolinz.goods_api.vo.SpecRespVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface SpecService extends IService<Spec> {

	/**
	 * 查询所有品牌
	 *
	 * @return 品牌集合
	 */
	List<Spec> findAll();


	/**
	 * 根据id查询对应品牌
	 * @param id 品牌id
	 * @return 品牌对象
	 */
	Spec findSpecById(Integer id);


	/**
	 * 添加规格
	 * @param spec 规格信息
	 */
	void addSpec(Spec spec);

	/**
	 * 修改规格
	 * @param spec 规格对象
	 */
	void updateSpec(Spec spec);


	/**
	 * 删除规格
	 * @param id 规格id
	 */
	void deleteSpec(Integer id);

	/**
	 * 条件查询规格
	 * @param spec 规格条件信息
	 * @return 查询到的规格集
	 */
	List<Spec> findSpecByConditions(Spec spec);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Spec> findByPage(PageSpecRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Spec> findByPageAndCondition(PageSpecRequestVo vo);

	/**
	 * 根据分类名称查询规格参数
	 * @param categoryName 分类名称
	 * @return 规格参数集
	 */
	List<SpecRespVo> findSpecListByCategoryName(String categoryName);

}


package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Pref;
import top.xiaolinz.goods_api.entity.Pref;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PagePrefRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface PrefService extends IService<Pref> {

	/**
	 * 查询所有优惠
	 *
	 * @return 优惠集合
	 */
	List<Pref> findAll();


	/**
	 * 根据id查询对应优惠
	 * @param id 优惠id
	 * @return 优惠对象
	 */
	Pref findPrefById(Integer id);


	/**
	 * 添加数据
	 * @param Pref 数据信息
	 */
	void addPref(Pref Pref);

	/**
	 * 修改数据
	 * @param Pref 数据对象
	 */
	void updatePref(Pref Pref);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deletePref(Integer id);

	/**
	 * 条件查询数据
	 * @param Pref 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Pref> findPrefByConditions(Pref Pref);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Pref> findByPage(PagePrefRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Pref> findByPageAndCondition(PagePrefRequestVo vo);

}


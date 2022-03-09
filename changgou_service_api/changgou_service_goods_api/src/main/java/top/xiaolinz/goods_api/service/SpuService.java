package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.entity.Spu;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageSpuRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface SpuService extends IService<Spu> {

	/**
	 * 查询所有spu
	 *
	 * @return spu集合
	 */
	List<Spu> findAll();


	/**
	 * 根据id查询对应spu
	 * @param id spuId
	 * @return spu对象
	 */
	Spu findSpuById(Integer id);


	/**
	 * 添加数据
	 * @param Spu 数据信息
	 */
	void addSpu(Spu Spu);

	/**
	 * 修改数据
	 * @param Spu 数据对象
	 */
	void updateSpu(Spu Spu);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deleteSpu(Integer id);

	/**
	 * 条件查询数据
	 * @param Spu 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Spu> findSpuByConditions(Spu Spu);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Spu> findByPage(PageSpuRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Spu> findByPageAndCondition(PageSpuRequestVo vo);
}


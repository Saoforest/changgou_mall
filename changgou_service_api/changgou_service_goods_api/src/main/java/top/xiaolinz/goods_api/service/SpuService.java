package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.entity.Spu;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.Goods;
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
	void deleteSpu(String spuId);

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

	/**
	 * 添加完整商品单元
	 * @param goods 商品信息封装
	 */
	void addSpuAndSku(Goods goods);

	/**
	 * 根据spuId查询完整商品单元
	 * @param id spuId
	 * @return 完整商品单元
	 */
	Goods findGoodsBySpuId(String id);

	/**
	 * 更新完整商品单元
	 * @param goods 商品单元
	 */
	void updateGoods(Goods goods);

	/**
	 * 审核商品
	 * @param spuId spuId
	 */
	void goodsAudit(String spuId);


	/**
	 * 商品上架
	 * @param spuId 商品id
	 */
	 void goodsPut(String spuId);

	/**
	 * 商品下架
	 * @param spuId 商品id
	 */
	void goodsDown(String spuId);

	/**
	 * 商品恢复
	 * @param spuId 商品id
	 */
	void restore(String spuId);
}


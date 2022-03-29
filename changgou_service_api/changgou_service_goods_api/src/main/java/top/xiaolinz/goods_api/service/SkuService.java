package top.xiaolinz.goods_api.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.vo.PageSkuRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface SkuService extends IService<Sku> {

	/**
	 * 查询所有sku
	 *
	 * @return sku集合
	 */
	List<Sku> findAll();


	/**
	 * 根据id查询对应sku
	 * @param id skuId
	 * @return sku对象
	 */
    Sku findSkuById(String id);


	/**
	 * 添加数据
	 * @param Sku 数据信息
	 */
	void addSku(Sku Sku);

	/**
	 * 修改数据
	 * @param Sku 数据对象
	 */
	void updateSku(Sku Sku);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deleteSku(Integer id);

	/**
	 * 条件查询数据
	 * @param Sku 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Sku> findSkuByConditions(Sku Sku);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Sku> findByPage(PageSkuRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Sku> findByPageAndCondition(PageSkuRequestVo vo);

    /**
     * 根据spuId查询所有sku,如果传入参数为"all" 则查询所有已上架的商品
     * 
     * @param spuId
     *            spuId
     * @return sku集合
     */
    List<Sku> findSkuListBySpuId(String spuId);

	void decrCount();
}


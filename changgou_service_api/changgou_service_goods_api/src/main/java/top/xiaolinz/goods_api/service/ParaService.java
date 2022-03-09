package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Para;
import top.xiaolinz.goods_api.entity.Para;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageParaRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface ParaService extends IService<Para> {

	/**
	 * 查询所有品牌
	 *
	 * @return 品牌集合
	 */
	List<Para> findAll();


	/**
	 * 根据id查询对应品牌
	 * @param id 品牌id
	 * @return 品牌对象
	 */
	Para findParaById(Integer id);


	/**
	 * 添加数据
	 * @param Para 数据信息
	 */
	void addPara(Para Para);

	/**
	 * 修改数据
	 * @param Para 数据对象
	 */
	void updatePara(Para Para);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deletePara(Integer id);

	/**
	 * 条件查询数据
	 * @param Para 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Para> findParaByConditions(Para Para);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Para> findByPage(PageParaRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Para> findByPageAndCondition(PageParaRequestVo vo);
}


package top.xiaolinz.goods_api.service;

import top.xiaolinz.goods_api.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

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

}


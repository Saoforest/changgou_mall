package top.xiaolinz.goods.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.xiaolinz.goods_api.entity.Brand;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
public interface BrandMapper extends BaseMapper<Brand> {

	/**
	 * 根据分类名字查询品牌
	 * @param ew 条件构造器
	 * @return 品牌集合
	 */
	@Select("select t1.name,t1.image from tb_brand t1 join tb_category_brand t2 on t1.id = t2.brand_id join tb_category t3 on t2.category_id = t3.id ${ew.customSqlSegment}")
	List<Brand> findBrandListByCategoryName(@Param(Constants.WRAPPER) Wrapper<Brand> wrapper);

}
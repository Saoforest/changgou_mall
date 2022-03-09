package top.xiaolinz.goods.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import top.xiaolinz.goods_api.entity.Spec;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
public interface SpecMapper extends BaseMapper<Spec> {
	/**
	 * 根据分类名称获取对应规格
	 * @param wrapper 条件构造对象
	 * @return 规格集
	 */

	List<Spec> findSpecListByCategoryName(@Param(Constants.WRAPPER) Wrapper<Spec> wrapper);
}
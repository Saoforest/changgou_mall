package top.xiaolinz.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.xiaolinz.goods_api.entity.Spu;

/**
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
public interface SpuMapper extends BaseMapper<Spu> {

	/**
	 * 查询商品,忽略逻辑删除
	 * @param spuId
	 * @return
	 */
	Spu findSpuByIdIgnoreDelete(@Param("spuId") String spuId);

	/**
	 * 恢复被删除的商品
	 * @param spu spu对象
	 */
	void updateSpuByIdRestore(Spu spu);
}
package top.xiaolinz.goods.exception;

import org.springframework.util.CollectionUtils;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.constant.ExceptionEnum;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.goods_api.entity.Spu;

import java.util.Collection;

/**
 * @author XiaoLin
 * @date 2022/3/10 00:03
 * @blog https://www.xiaolinz.top/
 **/
public class Assert {

	/**
	 * 判断对象是否为空
	 */
	public static boolean objIsNull(Object obj){
		if (obj == null) {
		    return true;
		}
		return false;
	}

	public static void notNull(Object obj, ExceptionEnum e) {
		if (obj == null) {
			throw new BusinessException(e);
		}
	}

	public static <T> void listNotEmpty(Collection<T> skuList) {
		if (CollectionUtils.isEmpty(skuList)){
			throw new BusinessException(StatusCode.ERROR, "参数为空");
		}
	}

	public static void isVerify(Spu spu){
		if (!"1".equals(spu.getStatus())) {
			throw new BusinessException(StatusCode.ERROR,"商品未审核");
        }
	}

	public static void isMarketable(Spu spu){
		if (!"0".equals(spu.getIsMarketable())) {
			throw new BusinessException(StatusCode.ERROR, "商品处于下架状态才可删除");
        }
	}

	public static void isDelete(Spu spu) {
		if (!"1".equals(spu.getIsDelete())) {
			throw new BusinessException(StatusCode.ERROR, "商品处于未删除状态");
        }
	}
}

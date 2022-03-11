package top.xiaolinz.goods_api.vo;

import lombok.Data;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.entity.Spu;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/10 10:48
 * @blog https://www.xiaolinz.top/
 **/
@Data
public class Goods {
	private Spu spu;

	private List<Sku> skuList;
}

package top.xiaolinz.goods.mapper;

import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.order_api.entity.OrderItem;

/**
 * @author XiaoLin
 * @date 2022/3/7 00:17
 * @blog https://www.xiaolinz.top/
 **/
public interface SkuMapper extends BaseMapper<Sku> {

    /**
     * 删除库存
     * @param orderItem 购物车商品信息封装类
     * @return 影响行数
     */
    @Update("update tb_sku set num = num - #{num},sale_num = sale_num + #{num} where id = #{skuId} and num >= #{num}")
    int decrCount(OrderItem orderItem);
}
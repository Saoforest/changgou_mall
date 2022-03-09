package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.OrderItem;
import top.xiaolinz.order_api.entity.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.vo.PageOrderItemRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface OrderItemService extends IService<OrderItem>{
    /**
     * 查询所有orderItem
     *
     * @return orderItem集合
     */
    List<OrderItem> findAll();


    /**
     * 根据id查询对应orderItem
     * @param id orderItemId
     * @return orderItem对象
     */
    OrderItem findOrderItemById(Integer id);


    /**
     * 添加数据
     * @param orderItem 数据信息
     */
    void addOrderItem(OrderItem orderItem);

    /**
     * 修改数据
     * @param orderItem 数据对象
     */
    void updateOrderItem(OrderItem orderItem);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteOrderItem(Integer id);

    /**
     * 条件查询数据
     * @param orderItem 数据条件信息
     * @return 查询到的数据集
     */
    List<OrderItem> findOrderItemByConditions(OrderItem orderItem);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<OrderItem> findByPage(PageOrderItemRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<OrderItem> findByPageAndCondition(PageOrderItemRequestVo vo);

}

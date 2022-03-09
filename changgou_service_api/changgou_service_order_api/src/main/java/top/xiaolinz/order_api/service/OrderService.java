package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.entity.Order;
import top.xiaolinz.order_api.vo.PageOrderRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface OrderService extends IService<Order>{
    /**
     * 查询所有order
     *
     * @return order集合
     */
    List<Order> findAll();


    /**
     * 根据id查询对应order
     * @param id orderId
     * @return order对象
     */
    Order findOrderById(Integer id);


    /**
     * 添加数据
     * @param order 数据信息
     */
    void addOrder(Order order);

    /**
     * 修改数据
     * @param order 数据对象
     */
    void updateOrder(Order order);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteOrder(Integer id);

    /**
     * 条件查询数据
     * @param order 数据条件信息
     * @return 查询到的数据集
     */
    List<Order> findOrderByConditions(Order order);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Order> findByPage(PageOrderRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Order> findByPageAndCondition(PageOrderRequestVo vo);

}

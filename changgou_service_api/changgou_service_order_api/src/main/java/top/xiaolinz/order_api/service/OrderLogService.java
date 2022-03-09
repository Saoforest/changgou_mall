package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.OrderLog;
import top.xiaolinz.order_api.entity.OrderLog;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.vo.PageOrderLogRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface OrderLogService extends IService<OrderLog>{

    /**
     * 查询所有orderLog
     *
     * @return orderLog集合
     */
    List<OrderLog> findAll();


    /**
     * 根据id查询对应orderLog
     * @param id orderLogId
     * @return orderLog对象
     */
    OrderLog findOrderLogById(Integer id);


    /**
     * 添加数据
     * @param orderLog 数据信息
     */
    void addOrderLog(OrderLog orderLog);

    /**
     * 修改数据
     * @param orderLog 数据对象
     */
    void updateOrderLog(OrderLog orderLog);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteOrderLog(Integer id);

    /**
     * 条件查询数据
     * @param orderLog 数据条件信息
     * @return 查询到的数据集
     */
    List<OrderLog> findOrderLogByConditions(OrderLog orderLog);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<OrderLog> findByPage(PageOrderLogRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<OrderLog> findByPageAndCondition(PageOrderLogRequestVo vo);

}

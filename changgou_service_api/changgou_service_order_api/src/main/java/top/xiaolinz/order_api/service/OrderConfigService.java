package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.OrderConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.entity.OrderConfig;
import top.xiaolinz.order_api.vo.PageOrderConfigRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface OrderConfigService extends IService<OrderConfig>{
    /**
     * 查询所有orderConfig
     *
     * @return orderConfig集合
     */
    List<OrderConfig> findAll();


    /**
     * 根据id查询对应orderConfig
     * @param id orderConfigId
     * @return orderConfig对象
     */
    OrderConfig findOrderConfigById(Integer id);


    /**
     * 添加数据
     * @param orderConfig 数据信息
     */
    void addOrderConfig(OrderConfig orderConfig);

    /**
     * 修改数据
     * @param orderConfig 数据对象
     */
    void updateOrderConfig(OrderConfig orderConfig);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteOrderConfig(Integer id);

    /**
     * 条件查询数据
     * @param orderConfig 数据条件信息
     * @return 查询到的数据集
     */
    List<OrderConfig> findOrderConfigByConditions(OrderConfig orderConfig);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<OrderConfig> findByPage(PageOrderConfigRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<OrderConfig> findByPageAndCondition(PageOrderConfigRequestVo vo);

}

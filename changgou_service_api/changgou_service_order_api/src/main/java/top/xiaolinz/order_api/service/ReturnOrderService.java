package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.ReturnOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.entity.ReturnOrder;
import top.xiaolinz.order_api.vo.PageReturnOrderRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface ReturnOrderService extends IService<ReturnOrder>{

    /**
     * 查询所有returnOrder
     *
     * @return returnOrder集合
     */
    List<ReturnOrder> findAll();


    /**
     * 根据id查询对应returnOrder
     * @param id returnOrderId
     * @return returnOrder对象
     */
    ReturnOrder findReturnOrderById(Integer id);


    /**
     * 添加数据
     * @param returnOrder 数据信息
     */
    void addReturnOrder(ReturnOrder returnOrder);

    /**
     * 修改数据
     * @param returnOrder 数据对象
     */
    void updateReturnOrder(ReturnOrder returnOrder);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteReturnOrder(Integer id);

    /**
     * 条件查询数据
     * @param returnOrder 数据条件信息
     * @return 查询到的数据集
     */
    List<ReturnOrder> findReturnOrderByConditions(ReturnOrder returnOrder);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<ReturnOrder> findByPage(PageReturnOrderRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<ReturnOrder> findByPageAndCondition(PageReturnOrderRequestVo vo);
}

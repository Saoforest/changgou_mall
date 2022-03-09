package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.ReturnOrderItem;
import top.xiaolinz.order_api.entity.ReturnOrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.vo.PageReturnOrderItemRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface ReturnOrderItemService extends IService<ReturnOrderItem>{

    /**
     * 查询所有returnOrderItem
     *
     * @return returnOrderItem集合
     */
    List<ReturnOrderItem> findAll();


    /**
     * 根据id查询对应returnOrderItem
     * @param id returnOrderItemId
     * @return returnOrderItem对象
     */
    ReturnOrderItem findReturnOrderItemById(Integer id);


    /**
     * 添加数据
     * @param returnOrderItem 数据信息
     */
    void addReturnOrderItem(ReturnOrderItem returnOrderItem);

    /**
     * 修改数据
     * @param returnOrderItem 数据对象
     */
    void updateReturnOrderItem(ReturnOrderItem returnOrderItem);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteReturnOrderItem(Integer id);

    /**
     * 条件查询数据
     * @param returnOrderItem 数据条件信息
     * @return 查询到的数据集
     */
    List<ReturnOrderItem> findReturnOrderItemByConditions(ReturnOrderItem returnOrderItem);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<ReturnOrderItem> findByPage(PageReturnOrderItemRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<ReturnOrderItem> findByPageAndCondition(PageReturnOrderItemRequestVo vo);

}

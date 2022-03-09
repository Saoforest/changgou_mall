package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.ReturnCause;
import top.xiaolinz.order_api.entity.ReturnCause;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.vo.PageReturnCauseRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface ReturnCauseService extends IService<ReturnCause>{

    /**
     * 查询所有returnCause
     *
     * @return returnCause集合
     */
    List<ReturnCause> findAll();


    /**
     * 根据id查询对应returnCause
     * @param id returnCauseId
     * @return returnCause对象
     */
    ReturnCause findReturnCauseById(Integer id);


    /**
     * 添加数据
     * @param returnCause 数据信息
     */
    void addReturnCause(ReturnCause returnCause);

    /**
     * 修改数据
     * @param returnCause 数据对象
     */
    void updateReturnCause(ReturnCause returnCause);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteReturnCause(Integer id);

    /**
     * 条件查询数据
     * @param returnCause 数据条件信息
     * @return 查询到的数据集
     */
    List<ReturnCause> findReturnCauseByConditions(ReturnCause returnCause);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<ReturnCause> findByPage(PageReturnCauseRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<ReturnCause> findByPageAndCondition(PageReturnCauseRequestVo vo);

}

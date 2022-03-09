package top.xiaolinz.order_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.UndoLog;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.order_api.vo.PageUndoLogRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface UndoLogService extends IService<UndoLog>{
    /**
     * 查询所有undoLog
     *
     * @return undoLog集合
     */
    List<UndoLog> findAll();


    /**
     * 根据id查询对应undoLog
     * @param id undoLogId
     * @return undoLog对象
     */
    UndoLog findUndoLogById(Integer id);


    /**
     * 添加数据
     * @param UndoLog 数据信息
     */
    void addUndoLog(UndoLog undoLog);

    /**
     * 修改数据
     * @param UndoLog 数据对象
     */
    void updateUndoLog(UndoLog undoLog);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteUndoLog(Integer id);

    /**
     * 条件查询数据
     * @param UndoLog 数据条件信息
     * @return 查询到的数据集
     */
    List<UndoLog> findUndoLogByConditions(UndoLog undoLog);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<UndoLog> findByPage(PageUndoLogRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<UndoLog> findByPageAndCondition(PageUndoLogRequestVo vo);

}

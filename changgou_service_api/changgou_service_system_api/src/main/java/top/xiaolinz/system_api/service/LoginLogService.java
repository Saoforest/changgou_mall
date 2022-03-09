package top.xiaolinz.system_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.system_api.entity.LoginLog;
import top.xiaolinz.system_api.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.system_api.vo.PageLoginLogRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
public interface LoginLogService extends IService<LoginLog>{

    /**
     * 查询所有loginLog
     *
     * @return loginLog集合
     */
    List<LoginLog> findAll();


    /**
     * 根据id查询对应loginLog
     * @param id loginLogId
     * @return loginLog对象
     */
    LoginLog findLoginLogById(Integer id);


    /**
     * 添加数据
     * @param LoginLog 数据信息
     */
    void addLoginLog(LoginLog loginLog);

    /**
     * 修改数据
     * @param LoginLog 数据对象
     */
    void updateLoginLog(LoginLog loginLog);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteLoginLog(Integer id);

    /**
     * 条件查询数据
     * @param LoginLog 数据条件信息
     * @return 查询到的数据集
     */
    List<LoginLog> findLoginLogByConditions(LoginLog loginLog);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<LoginLog> findByPage(PageLoginLogRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<LoginLog> findByPageAndCondition(PageLoginLogRequestVo vo);
}

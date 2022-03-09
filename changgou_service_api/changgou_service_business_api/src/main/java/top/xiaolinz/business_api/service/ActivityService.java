package top.xiaolinz.business_api.service;

import top.xiaolinz.business_api.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.business_api.vo.PageActivityRequestVo;
import top.xiaolinz.common_db.utils.PageResult;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:41
* @blog https://www.xiaolinz.top/
* 
**/
public interface ActivityService extends IService<Activity>{

    /**
     * 查询所有activity
     *
     * @return activity集合
     */
    List<Activity> findAll();


    /**
     * 根据id查询对应activity
     * @param id activityId
     * @return activity对象
     */
    Activity findActivityById(Integer id);


    /**
     * 添加数据
     * @param Activity 数据信息
     */
    void addActivity(Activity Activity);

    /**
     * 修改数据
     * @param Activity 数据对象
     */
    void updateActivity(Activity Activity);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteActivity(Integer id);

    /**
     * 条件查询数据
     * @param Activity 数据条件信息
     * @return 查询到的数据集
     */
    List<Activity> findActivityByConditions(Activity Activity);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Activity> findByPage(PageActivityRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Activity> findByPageAndCondition(PageActivityRequestVo vo);

}

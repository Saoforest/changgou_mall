package top.xiaolinz.user_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.user_api.entity.Cities;
import top.xiaolinz.user_api.entity.Cities;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.user_api.vo.PageCitiesRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
public interface CitiesService extends IService<Cities>{

    /**
     * 查询所有cities
     *
     * @return cities集合
     */
    List<Cities> findAll();


    /**
     * 根据id查询对应cities
     * @param id citiesId
     * @return cities对象
     */
    Cities findCitiesById(Integer id);


    /**
     * 添加数据
     * @param Cities 数据信息
     */
    void addCities(Cities cities);

    /**
     * 修改数据
     * @param Cities 数据对象
     */
    void updateCities(Cities cities);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteCities(Integer id);

    /**
     * 条件查询数据
     * @param Cities 数据条件信息
     * @return 查询到的数据集
     */
    List<Cities> findCitiesByConditions(Cities cities);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Cities> findByPage(PageCitiesRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Cities> findByPageAndCondition(PageCitiesRequestVo vo);
}

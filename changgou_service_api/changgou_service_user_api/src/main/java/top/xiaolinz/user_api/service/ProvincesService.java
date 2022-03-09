package top.xiaolinz.user_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.user_api.entity.Provinces;
import top.xiaolinz.user_api.entity.Provinces;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.user_api.vo.PageProvincesRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
public interface ProvincesService extends IService<Provinces>{
    /**
     * 查询所有provinces
     *
     * @return provinces集合
     */
    List<Provinces> findAll();


    /**
     * 根据id查询对应provinces
     * @param id provincesId
     * @return provinces对象
     */
    Provinces findProvincesById(Integer id);


    /**
     * 添加数据
     * @param Provinces 数据信息
     */
    void addProvinces(Provinces provinces);

    /**
     * 修改数据
     * @param Provinces 数据对象
     */
    void updateProvinces(Provinces provinces);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteProvinces(Integer id);

    /**
     * 条件查询数据
     * @param Provinces 数据条件信息
     * @return 查询到的数据集
     */
    List<Provinces> findProvincesByConditions(Provinces provinces);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Provinces> findByPage(PageProvincesRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Provinces> findByPageAndCondition(PageProvincesRequestVo vo);

}

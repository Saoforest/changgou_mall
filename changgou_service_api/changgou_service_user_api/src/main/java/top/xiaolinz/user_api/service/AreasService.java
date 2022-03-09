package top.xiaolinz.user_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.user_api.entity.Areas;
import top.xiaolinz.user_api.entity.Areas;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.user_api.vo.PageAreasRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
public interface AreasService extends IService<Areas>{

    /**
     * 查询所有areas
     *
     * @return areas集合
     */
    List<Areas> findAll();


    /**
     * 根据id查询对应areas
     * @param id areasId
     * @return areas对象
     */
    Areas findAreasById(Integer id);


    /**
     * 添加数据
     * @param Areas 数据信息
     */
    void addAreas(Areas areas);

    /**
     * 修改数据
     * @param Areas 数据对象
     */
    void updateAreas(Areas areas);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteAreas(Integer id);

    /**
     * 条件查询数据
     * @param Areas 数据条件信息
     * @return 查询到的数据集
     */
    List<Areas> findAreasByConditions(Areas areas);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Areas> findByPage(PageAreasRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Areas> findByPageAndCondition(PageAreasRequestVo vo);
}

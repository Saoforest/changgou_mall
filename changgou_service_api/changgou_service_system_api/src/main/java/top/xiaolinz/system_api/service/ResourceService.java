package top.xiaolinz.system_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.system_api.entity.Resource;
import top.xiaolinz.system_api.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.system_api.vo.PageResourceRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
public interface ResourceService extends IService<Resource>{


    /**
     * 查询所有resource
     *
     * @return resource集合
     */
    List<Resource> findAll();


    /**
     * 根据id查询对应resource
     * @param id resourceId
     * @return resource对象
     */
    Resource findResourceById(Integer id);


    /**
     * 添加数据
     * @param Resource 数据信息
     */
    void addResource(Resource resource);

    /**
     * 修改数据
     * @param Resource 数据对象
     */
    void updateResource(Resource resource);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteResource(Integer id);

    /**
     * 条件查询数据
     * @param Resource 数据条件信息
     * @return 查询到的数据集
     */
    List<Resource> findResourceByConditions(Resource resource);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Resource> findByPage(PageResourceRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Resource> findByPageAndCondition(PageResourceRequestVo vo);
    
}

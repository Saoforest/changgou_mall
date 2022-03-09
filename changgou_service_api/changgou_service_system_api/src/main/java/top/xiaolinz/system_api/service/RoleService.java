package top.xiaolinz.system_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.system_api.entity.Role;
import top.xiaolinz.system_api.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.system_api.vo.PageRoleRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
public interface RoleService extends IService<Role>{

    /**
     * 查询所有role
     *
     * @return role集合
     */
    List<Role> findAll();


    /**
     * 根据id查询对应role
     * @param id roleId
     * @return role对象
     */
    Role findRoleById(Integer id);


    /**
     * 添加数据
     * @param Role 数据信息
     */
    void addRole(Role role);

    /**
     * 修改数据
     * @param Role 数据对象
     */
    void updateRole(Role role);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteRole(Integer id);

    /**
     * 条件查询数据
     * @param Role 数据条件信息
     * @return 查询到的数据集
     */
    List<Role> findRoleByConditions(Role role);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Role> findByPage(PageRoleRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Role> findByPageAndCondition(PageRoleRequestVo vo);
}

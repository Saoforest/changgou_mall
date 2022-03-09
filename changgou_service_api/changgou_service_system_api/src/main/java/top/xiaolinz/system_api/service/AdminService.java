package top.xiaolinz.system_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.system_api.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.system_api.vo.PageAdminRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
public interface AdminService extends IService<Admin>{

    /**
     * 查询所有admin
     *
     * @return admin集合
     */
    List<Admin> findAll();


    /**
     * 根据id查询对应admin
     * @param id adminId
     * @return admin对象
     */
    Admin findAdminById(Integer id);


    /**
     * 添加数据
     * @param Admin 数据信息
     */
    void addAdmin(Admin admin);

    /**
     * 修改数据
     * @param Admin 数据对象
     */
    void updateAdmin(Admin admin);

    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteAdmin(Integer id);

    /**
     * 条件查询数据
     * @param Admin 数据条件信息
     * @return 查询到的数据集
     */
    List<Admin> findAdminByConditions(Admin admin);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Admin> findByPage(PageAdminRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Admin> findByPageAndCondition(PageAdminRequestVo vo);

    /**
     * 用户登录
     * @param admin 用户参数信息
     * @return 是否登录成功
     */
    public boolean login(Admin admin);
}

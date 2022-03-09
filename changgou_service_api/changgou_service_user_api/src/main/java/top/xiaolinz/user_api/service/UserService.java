package top.xiaolinz.user_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.user_api.entity.User;
import top.xiaolinz.user_api.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.user_api.vo.PageUserRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
public interface UserService extends IService<User>{

    /**
     * 查询所有user
     *
     * @return user集合
     */
    List<User> findAll();


    /**
     * 根据id查询对应user
     * @param id userId
     * @return user对象
     */
    User findUserById(Integer id);


    /**
     * 添加数据
     * @param User 数据信息
     */
    void addUser(User user);

    /**
     * 修改数据
     * @param User 数据对象
     */
    void updateUser(User user);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteUser(Integer id);

    /**
     * 条件查询数据
     * @param User 数据条件信息
     * @return 查询到的数据集
     */
    List<User> findUserByConditions(User user);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<User> findByPage(PageUserRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<User> findByPageAndCondition(PageUserRequestVo vo);
}

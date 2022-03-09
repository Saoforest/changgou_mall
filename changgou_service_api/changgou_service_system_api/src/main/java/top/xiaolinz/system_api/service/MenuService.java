package top.xiaolinz.system_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.system_api.entity.Menu;
import top.xiaolinz.system_api.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.system_api.vo.PageMenuRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
public interface MenuService extends IService<Menu>{
    /**
     * 查询所有menu
     *
     * @return menu集合
     */
    List<Menu> findAll();


    /**
     * 根据id查询对应menu
     * @param id menuId
     * @return menu对象
     */
    Menu findMenuById(Integer id);


    /**
     * 添加数据
     * @param Menu 数据信息
     */
    void addMenu(Menu menu);

    /**
     * 修改数据
     * @param Menu 数据对象
     */
    void updateMenu(Menu menu);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteMenu(Integer id);

    /**
     * 条件查询数据
     * @param Menu 数据条件信息
     * @return 查询到的数据集
     */
    List<Menu> findMenuByConditions(Menu menu);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Menu> findByPage(PageMenuRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Menu> findByPageAndCondition(PageMenuRequestVo vo);

}

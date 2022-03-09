package top.xiaolinz.order_api.service;



import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.Preferential;
import top.xiaolinz.order_api.vo.PagePreferentialRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
public interface PreferentialService extends IService<Preferential> {
    /**
     * 查询所有preferential
     *
     * @return preferential集合
     */
    List<Preferential> findAll();


    /**
     * 根据id查询对应preferential
     * @param id preferentialId
     * @return preferential对象
     */
    Preferential findPreferentialById(Integer id);


    /**
     * 添加数据
     * @param preferential 数据信息
     */
    void addPreferential(Preferential preferential);

    /**
     * 修改数据
     * @param preferential 数据对象
     */
    void updatePreferential(Preferential preferential);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deletePreferential(Integer id);

    /**
     * 条件查询数据
     * @param preferential 数据条件信息
     * @return 查询到的数据集
     */
    List<Preferential> findPreferentialByConditions(Preferential preferential);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Preferential> findByPage(PagePreferentialRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Preferential> findByPageAndCondition(PagePreferentialRequestVo vo);

}

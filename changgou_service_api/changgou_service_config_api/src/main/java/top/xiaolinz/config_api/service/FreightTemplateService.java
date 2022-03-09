package top.xiaolinz.config_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.config_api.entity.FreightTemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.config_api.vo.PageFreightTemplateRequestVo;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:45
* @blog https://www.xiaolinz.top/
* 
**/
public interface FreightTemplateService extends IService<FreightTemplate>{

    /**
     * 查询所有freightTemplate
     *
     * @return freightTemplate集合
     */
    List<FreightTemplate> findAll();


    /**
     * 根据id查询对应freightTemplate
     * @param id freightTemplateId
     * @return freightTemplate对象
     */
    FreightTemplate findFreightTemplateById(Integer id);


    /**
     * 添加数据
     * @param freightTemplate 数据信息
     */
    void addFreightTemplate(FreightTemplate freightTemplate);

    /**
     * 修改数据
     * @param freightTemplate 数据对象
     */
    void updateFreightTemplate(FreightTemplate freightTemplate);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteFreightTemplate(Integer id);

    /**
     * 条件查询数据
     * @param FreightTemplate 数据条件信息
     * @return 查询到的数据集
     */
    List<FreightTemplate> findFreightTemplateByConditions(FreightTemplate freightTemplate);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<FreightTemplate> findByPage(PageFreightTemplateRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<FreightTemplate> findByPageAndCondition(PageFreightTemplateRequestVo vo);
}

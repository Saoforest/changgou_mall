package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Template;
import top.xiaolinz.goods_api.entity.Template;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageTemplateRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface TemplateService extends IService<Template> {

	/**
	 * 查询所有template
	 *
	 * @return template集合
	 */
	List<Template> findAll();


	/**
	 * 根据id查询对应template
	 * @param id templateId
	 * @return template对象
	 */
	Template findTemplateById(Integer id);


	/**
	 * 添加数据
	 * @param Template 数据信息
	 */
	void addTemplate(Template Template);

	/**
	 * 修改数据
	 * @param Template 数据对象
	 */
	void updateTemplate(Template Template);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deleteTemplate(Integer id);

	/**
	 * 条件查询数据
	 * @param Template 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Template> findTemplateByConditions(Template Template);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Template> findByPage(PageTemplateRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Template> findByPageAndCondition(PageTemplateRequestVo vo);
	
}


package top.xiaolinz.goods.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods_api.entity.Template;
import top.xiaolinz.goods_api.entity.Template;
import top.xiaolinz.goods.mapper.TemplateMapper;
import top.xiaolinz.goods_api.service.TemplateService;
import top.xiaolinz.goods_api.vo.PageTemplateRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements TemplateService {
	@Override
	public List<Template> findAll() {

		return this.list();
	}

	@Override
	public Template findTemplateById(Integer id) {

		final Template Template = this.getById(id);
		return Template;

	}

	@Override
	public void addTemplate(Template template) {
		this.save(template);
	}

	@Override
	public void updateTemplate(Template template) {
		this.updateById(template);
	}

	@Override
	public void deleteTemplate(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Template> findTemplateByConditions(Template template) {
		if(template == null){
			return new ArrayList<>();
		}

		final Wrapper<Template> wrapper = this.retrievalConditionStructure(template);


		final List<Template> templateList = this.list(wrapper);


		return templateList;
	}

	@Override
	public PageResult<Template> findByPage(PageTemplateRequestVo vo) {

		final HashMap<String, Object> templatems = new HashMap<>();
		templatems.put(PageConstant.PAGE,vo.getPage());
		templatems.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Template> page = this.page(new Query<Template>().getPage(templatems),new QueryWrapper<Template>());

		return new PageResult<Template>(page);
	}

	@Override
	public PageResult<Template> findByPageAndCondition(PageTemplateRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Template> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Template> page = this.page(new Query<Template>().getPage(map), wrapper);

		return new PageResult<Template>(page);
	}



	/**
	 * 多条件检索构造
	 * @param template 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Template> retrievalConditionStructure(Template template){
		final QueryWrapper<Template> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(template.getName())) {
			wrapper.like("name", template.getName());
        }

		if(template.getId() != null){
			wrapper.eq("id", template.getId());
		}

		if (template.getParaNum() != null){
			wrapper.eq("para_num",template.getParaNum());
		}

		if(template.getSpecNum() != null){
			wrapper.eq("spec_num",template.getSpecNum());
		}

		return wrapper;
	}

	public Wrapper<Template> retrievalConditionStructure(PageTemplateRequestVo template){
		final QueryWrapper<Template> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(template.getName())) {
			wrapper.like("name", template.getName());
		}

		if(template.getId() != null){
			wrapper.eq("id", template.getId());
		}

		if (template.getParaNum() != null){
			wrapper.eq("para_num",template.getParaNum());
		}

		if(template.getSpecNum() != null){
			wrapper.eq("spec_num",template.getSpecNum());
		}

		return wrapper;
	}
}


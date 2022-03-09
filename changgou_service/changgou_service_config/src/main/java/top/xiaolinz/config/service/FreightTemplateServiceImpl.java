package top.xiaolinz.config.service;

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
import top.xiaolinz.config.mapper.FreightTemplateMapper;
import top.xiaolinz.config_api.entity.FreightTemplate;
import top.xiaolinz.config_api.service.FreightTemplateService;
import top.xiaolinz.config_api.vo.PageFreightTemplateRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:45
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class FreightTemplateServiceImpl extends ServiceImpl<FreightTemplateMapper, FreightTemplate> implements FreightTemplateService{
	@Override
	public List<FreightTemplate> findAll() {

		return this.list();
	}

	@Override
	public FreightTemplate findFreightTemplateById(Integer id) {

		final FreightTemplate FreightTemplate = this.getById(id);
		return FreightTemplate;

	}

	@Override
	public void addFreightTemplate(FreightTemplate freightTemplate) {
		this.save(freightTemplate);
	}

	@Override
	public void updateFreightTemplate(FreightTemplate freightTemplate) {
		this.updateById(freightTemplate);
	}

	@Override
	public void deleteFreightTemplate(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<FreightTemplate> findFreightTemplateByConditions(FreightTemplate freightTemplate) {
		if(freightTemplate == null){
			return new ArrayList<>();
		}

		final Wrapper<FreightTemplate> wrapper = this.retrievalConditionStructure(freightTemplate);


		final List<FreightTemplate> freightTemplateList = this.list(wrapper);


		return freightTemplateList;
	}

	@Override
	public PageResult<FreightTemplate> findByPage(PageFreightTemplateRequestVo vo) {

		final HashMap<String, Object> freightTemplatems = new HashMap<>();
		freightTemplatems.put(PageConstant.PAGE,vo.getPage());
		freightTemplatems.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<FreightTemplate> page = this.page(new Query<FreightTemplate>().getPage(freightTemplatems),new QueryWrapper<FreightTemplate>());

		return new PageResult<FreightTemplate>(page);
	}

	@Override
	public PageResult<FreightTemplate> findByPageAndCondition(PageFreightTemplateRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<FreightTemplate> wrapper = this.retrievalConditionStructure(vo);

		final IPage<FreightTemplate> page = this.page(new Query<FreightTemplate>().getPage(map), wrapper);

		return new PageResult<FreightTemplate>(page);
	}



	/**
	 * 多条件检索构造
	 * @param freightTemplate 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<FreightTemplate> retrievalConditionStructure(FreightTemplate freightTemplate){
		final QueryWrapper<FreightTemplate> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(freightTemplate.getName())) {
			wrapper.like("name", freightTemplate.getName());
        }

		if (StringUtils.isNotBlank(freightTemplate.getType())){
			wrapper.like("type",freightTemplate.getType());
		}

		if (freightTemplate.getId() != null){
			wrapper.eq("id", freightTemplate.getId());
		}

		return wrapper;
	}

	public Wrapper<FreightTemplate> retrievalConditionStructure(PageFreightTemplateRequestVo freightTemplate){
		final QueryWrapper<FreightTemplate> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(freightTemplate.getName())) {
			wrapper.like("name", freightTemplate.getName());
		}

		if (StringUtils.isNotBlank(freightTemplate.getType())){
			wrapper.like("type",freightTemplate.getType());
		}

		if (freightTemplate.getId() != null){
			wrapper.eq("id", freightTemplate.getId());
		}

		return wrapper;
	}
}

package top.xiaolinz.goods.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods_api.entity.Spec;
import top.xiaolinz.goods.mapper.SpecMapper;
import top.xiaolinz.goods_api.service.SpecService;
import top.xiaolinz.goods_api.vo.PageBrandRequestVo;
import top.xiaolinz.goods_api.vo.PageSpecRequestVo;
import top.xiaolinz.goods_api.vo.SpecRespVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements SpecService {

	@Override
	public List<Spec> findAll() {

		return this.list();
	}

	@Override
	public Spec findSpecById(Integer id) {

		final Spec spec = this.getById(id);
		return spec;

	}

	@Override
	public void addSpec(Spec spec) {
		this.save(spec);
	}

	@Override
	public void updateSpec(Spec spec) {
		this.updateById(spec);
	}

	@Override
	public void deleteSpec(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Spec> findSpecByConditions(Spec spec) {
		if(spec == null){
			return new ArrayList<>();
		}

		final Wrapper<Spec> wrapper = this.retrievalConditionStructure(spec);


		final List<Spec> specList = this.list(wrapper);


		return specList;
	}

	@Override
	public PageResult<Spec> findByPage(PageSpecRequestVo vo) {

		final HashMap<String, Object> params = new HashMap<>();
		params.put(PageConstant.PAGE,vo.getPage());
		params.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Spec> page = this.page(new Query<Spec>().getPage(params),new QueryWrapper<Spec>());

		return new PageResult<Spec>(page);
	}

	@Override
	public PageResult<Spec> findByPageAndCondition(PageSpecRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Spec> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Spec> page = this.page(new Query<Spec>().getPage(map), wrapper);

		return new PageResult<Spec>(page);
	}


	@Override
	public List<SpecRespVo> findSpecListByCategoryName(String categoryName) {
		final QueryWrapper<Spec> wrapper = new QueryWrapper<>();
		wrapper.eq("t3.name",categoryName);
		final List<Spec> list = baseMapper.findSpecListByCategoryName(wrapper);
		final List<SpecRespVo> resp = list.stream().map(spec -> {
			final SpecRespVo vo = new SpecRespVo();
			BeanUtils.copyProperties(spec, vo);
			final List<String> options = Arrays.asList(spec.getOptions().split(","));
			vo.setOptions(options);
			return vo;
		}).collect(Collectors.toList());
		return resp;
	}

	/**
	 * 多条件检索构造
	 * @param spec 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Spec> retrievalConditionStructure(Spec spec){
		final QueryWrapper<Spec> wrapper = new QueryWrapper<>();
		if(StringUtils.isNotEmpty(spec.getName())){
			wrapper.like("name",spec.getName());
		}
		if(StringUtils.isNotEmpty(spec.getOptions())){
			wrapper.like("options",spec.getOptions());
		}
		if(spec.getId() != null){
			wrapper.eq("id", spec.getId());
		}
		if(spec.getSeq() != null){
			wrapper.eq("seq",spec.getSeq());
		}
		if(spec.getTemplateId() != null){
			wrapper.eq("template_id",spec.getTemplateId());
		}

		return wrapper;
	}

	/**
	 * 多条件检索构造
	 * @param spec 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Spec> retrievalConditionStructure(PageSpecRequestVo spec){
		final QueryWrapper<Spec> wrapper = new QueryWrapper<>();
		if(StringUtils.isNotEmpty(spec.getName())){
			wrapper.like("name",spec.getName());
		}
		if(StringUtils.isNotEmpty(spec.getOptions())){
			wrapper.like("options",spec.getOptions());
		}
		if(spec.getId() != null){
			wrapper.eq("id", spec.getId());
		}
		if(spec.getSeq() != null){
			wrapper.eq("seq",spec.getSeq());
		}
		if(spec.getTemplateId() != null){
			wrapper.eq("template_id",spec.getTemplateId());
		}

		return wrapper;
	}
}


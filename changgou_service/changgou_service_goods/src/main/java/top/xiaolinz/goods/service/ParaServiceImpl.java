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
import top.xiaolinz.goods_api.entity.Para;
import top.xiaolinz.goods.mapper.ParaMapper;
import top.xiaolinz.goods_api.service.ParaService;
import top.xiaolinz.goods_api.vo.PageParaRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class ParaServiceImpl extends ServiceImpl<ParaMapper, Para> implements ParaService {

	@Override
	public List<Para> findAll() {

		return this.list();
	}

	@Override
	public Para findParaById(Integer id) {

		final Para Para = this.getById(id);
		return Para;

	}

	@Override
	public void addPara(Para para) {
		this.save(para);
	}

	@Override
	public void updatePara(Para para) {
		this.updateById(para);
	}

	@Override
	public void deletePara(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Para> findParaByConditions(Para para) {
		if(para == null){
			return new ArrayList<>();
		}

		final Wrapper<Para> wrapper = this.retrievalConditionStructure(para);


		final List<Para> paraList = this.list(wrapper);


		return paraList;
	}

	@Override
	public PageResult<Para> findByPage(PageParaRequestVo vo) {

		final HashMap<String, Object> params = new HashMap<>();
		params.put(PageConstant.PAGE,vo.getPage());
		params.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Para> page = this.page(new Query<Para>().getPage(params),new QueryWrapper<Para>());

		return new PageResult<Para>(page);
	}

	@Override
	public PageResult<Para> findByPageAndCondition(PageParaRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Para> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Para> page = this.page(new Query<Para>().getPage(map), wrapper);

		return new PageResult<Para>(page);
	}



	/**
	 * 多条件检索构造
	 * @param para 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Para> retrievalConditionStructure(Para para){
		final QueryWrapper<Para> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(para.getOptions())) {
			wrapper.like("options",para.getOptions());
        }
		if(StringUtils.isNotBlank(para.getName())){
			wrapper.like("name",para.getName());
		}
		if(para.getId() != null){
			wrapper.eq("id",para.getId());
		}
		if(para.getSeq() != null){
			wrapper.eq("seq",para.getSeq());
		}
		if(para.getTemplateId() != null){
			wrapper.eq("template_id",para.getTemplateId());
		}

		return wrapper;
	}

	/**
	 * 多条件检索构造
	 * @param para 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Para> retrievalConditionStructure(PageParaRequestVo para){
		final QueryWrapper<Para> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(para.getOptions())) {
			wrapper.like("options",para.getOptions());
		}
		if(StringUtils.isNotBlank(para.getName())){
			wrapper.like("name",para.getName());
		}
		if(para.getId() != null){
			wrapper.eq("id",para.getId());
		}
		if(para.getSeq() != null){
			wrapper.eq("seq",para.getSeq());
		}
		if(para.getTemplateId() != null){
			wrapper.eq("template_id",para.getTemplateId());
		}

		return wrapper;
	}

}


package top.xiaolinz.order.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.order.mapper.PreferentialMapper;
import top.xiaolinz.order_api.entity.Preferential;
import top.xiaolinz.order_api.service.PreferentialService;
import top.xiaolinz.order_api.vo.PagePreferentialRequestVo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class PreferentialServiceImpl extends ServiceImpl<PreferentialMapper, Preferential> implements PreferentialService {
	@Override
	public List<Preferential> findAll() {

		return this.list();
	}

	@Override
	public Preferential findPreferentialById(Integer id) {

		final Preferential Preferential = this.getById(id);
		return Preferential;

	}

	@Override
	public void addPreferential(Preferential preferential) {
		this.save(preferential);
	}

	@Override
	public void updatePreferential(Preferential preferential) {
		this.updateById(preferential);
	}

	@Override
	public void deletePreferential(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Preferential> findPreferentialByConditions(Preferential preferential) {
		if(preferential == null){
			return new ArrayList<>();
		}

		final Wrapper<Preferential> wrapper = this.retrievalConditionStructure(preferential);


		final List<Preferential> preferentialList = this.list(wrapper);


		return preferentialList;
	}

	@Override
	public PageResult<Preferential> findByPage(PagePreferentialRequestVo vo) {

		final HashMap<String, Object> preferentialms = new HashMap<>();
		preferentialms.put(PageConstant.PAGE,vo.getPage());
		preferentialms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Preferential> page = this.page(new Query<Preferential>().getPage(preferentialms),new QueryWrapper<Preferential>());

		return new PageResult<Preferential>(page);
	}

	@Override
	public PageResult<Preferential> findByPageAndCondition(PagePreferentialRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Preferential> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Preferential> page = this.page(new Query<Preferential>().getPage(map), wrapper);

		return new PageResult<Preferential>(page);
	}



	/**
	 * 多条件检索构造
	 * @param preferential 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Preferential> retrievalConditionStructure(Preferential preferential){
		final QueryWrapper<Preferential> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(preferential.getState())) {
			wrapper.like("state", preferential.getState());
		}

		if (StringUtils.isNotBlank(preferential.getType())){
			wrapper.like("type",preferential.getType());
		}

		if (preferential.getId() != null){
			wrapper.eq("id", preferential.getId());
		}

		if (preferential.getBuyMoney() != null) {
			wrapper.eq("buy_money",preferential.getBuyMoney());
		}

		if (preferential.getPreMoney() != null){
			wrapper.eq("pre_money",preferential.getPreMoney());
		}

		if (preferential.getCategoryId() != null){
			wrapper.eq("category_id",preferential.getCategoryId());
		}





		return wrapper;
	}

	public Wrapper<Preferential> retrievalConditionStructure(PagePreferentialRequestVo preferential){
		final QueryWrapper<Preferential> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(preferential.getState())) {
			wrapper.like("state", preferential.getState());
        }

		if (StringUtils.isNotBlank(preferential.getType())){
			wrapper.like("type",preferential.getType());
		}

		if (preferential.getId() != null){
			wrapper.eq("id", preferential.getId());
		}

		if (preferential.getBuyMoney() != null) {
			wrapper.eq("buy_money",preferential.getBuyMoney());
        }

		if (preferential.getPreMoney() != null){
			wrapper.eq("pre_money",preferential.getPreMoney());
		}

		if (preferential.getCategoryId() != null){
			wrapper.eq("category_id",preferential.getCategoryId());
		}

		return wrapper;
	}
}

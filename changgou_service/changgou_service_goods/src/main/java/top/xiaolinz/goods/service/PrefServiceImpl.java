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
import top.xiaolinz.goods_api.entity.Pref;
import top.xiaolinz.goods_api.entity.Pref;
import top.xiaolinz.goods.mapper.PrefMapper;
import top.xiaolinz.goods_api.service.PrefService;
import top.xiaolinz.goods_api.vo.PagePrefRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class PrefServiceImpl extends ServiceImpl<PrefMapper, Pref> implements PrefService {
	@Override
	public List<Pref> findAll() {

		return this.list();
	}

	@Override
	public Pref findPrefById(Integer id) {

		final Pref Pref = this.getById(id);
		return Pref;

	}

	@Override
	public void addPref(Pref pref) {
		this.save(pref);
	}

	@Override
	public void updatePref(Pref pref) {
		this.updateById(pref);
	}

	@Override
	public void deletePref(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Pref> findPrefByConditions(Pref pref) {
		if(pref == null){
			return new ArrayList<>();
		}

		final Wrapper<Pref> wrapper = this.retrievalConditionStructure(pref);


		final List<Pref> prefList = this.list(wrapper);


		return prefList;
	}

	@Override
	public PageResult<Pref> findByPage(PagePrefRequestVo vo) {

		final HashMap<String, Object> prefms = new HashMap<>();
		prefms.put(PageConstant.PAGE,vo.getPage());
		prefms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Pref> page = this.page(new Query<Pref>().getPage(prefms),new QueryWrapper<Pref>());

		return new PageResult<Pref>(page);
	}

	@Override
	public PageResult<Pref> findByPageAndCondition(PagePrefRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Pref> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Pref> page = this.page(new Query<Pref>().getPage(map), wrapper);

		return new PageResult<Pref>(page);
	}



	/**
	 * 多条件检索构造
	 * @prefm pref 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Pref> retrievalConditionStructure(Pref pref){
		final QueryWrapper<Pref> wrapper = new QueryWrapper<>();

		if(pref.getId() != null){
			wrapper.eq("id",pref.getId());
		}

		if(pref.getCateId() != null){
			wrapper.eq("cate_Id",pref.getCateId());
		}

		if(pref.getPreMoney() != null){
			wrapper.eq("pre_money",pref.getPreMoney());
		}

		if (pref.getBuyMoney() != null){
			wrapper.eq("buy_money",pref.getBuyMoney());
		}

		return wrapper;
	}

	/**
	 * 多条件检索构造
	 * @prefm pref 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Pref> retrievalConditionStructure(PagePrefRequestVo pref){
		final QueryWrapper<Pref> wrapper = new QueryWrapper<>();

		if(pref.getId() != null){
			wrapper.eq("id",pref.getId());
		}

		if(pref.getCateId() != null){
			wrapper.eq("cate_Id",pref.getCateId());
		}

		if(pref.getPreMoney() != null){
			wrapper.eq("pre_money",pref.getPreMoney());
		}

		if (pref.getBuyMoney() != null){
			wrapper.eq("buy_money",pref.getBuyMoney());
		}

		return wrapper;
	}
}


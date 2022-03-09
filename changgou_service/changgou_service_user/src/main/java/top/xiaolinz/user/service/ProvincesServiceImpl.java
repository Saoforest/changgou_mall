package top.xiaolinz.user.service;

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
import top.xiaolinz.user_api.entity.Provinces;
import top.xiaolinz.user_api.entity.Provinces;
import top.xiaolinz.user.mapper.ProvincesMapper;
import top.xiaolinz.user_api.service.ProvincesService;
import top.xiaolinz.user_api.vo.PageProvincesRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class ProvincesServiceImpl extends ServiceImpl<ProvincesMapper, Provinces> implements ProvincesService{
	@Override
	public List<Provinces> findAll() {

		return this.list();
	}

	@Override
	public Provinces findProvincesById(Integer id) {

		final Provinces Provinces = this.getById(id);
		return Provinces;

	}

	@Override
	public void addProvinces(Provinces provinces) {
		this.save(provinces);
	}

	@Override
	public void updateProvinces(Provinces provinces) {
		this.updateById(provinces);
	}

	@Override
	public void deleteProvinces(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Provinces> findProvincesByConditions(Provinces provinces) {
		if(provinces == null){
			return new ArrayList<>();
		}

		final Wrapper<Provinces> wrapper = this.retrievalConditionStructure(provinces);


		final List<Provinces> provincesList = this.list(wrapper);


		return provincesList;
	}

	@Override
	public PageResult<Provinces> findByPage(PageProvincesRequestVo vo) {

		final HashMap<String, Object> provincesms = new HashMap<>();
		provincesms.put(PageConstant.PAGE,vo.getPage());
		provincesms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Provinces> page = this.page(new Query<Provinces>().getPage(provincesms),new QueryWrapper<Provinces>());

		return new PageResult<Provinces>(page);
	}

	@Override
	public PageResult<Provinces> findByPageAndCondition(PageProvincesRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Provinces> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Provinces> page = this.page(new Query<Provinces>().getPage(map), wrapper);

		return new PageResult<Provinces>(page);
	}



	/**
	 * 多条件检索构造
	 * @param provinces 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Provinces> retrievalConditionStructure(Provinces provinces){
		final QueryWrapper<Provinces> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(provinces.getProvince())) {
			wrapper.like("province",provinces.getProvince());
		}

		if (StringUtils.isNotBlank(provinces.getProvinceid())){
			wrapper.like("provinceid",provinces.getProvinceid());
		}

		return wrapper;
	}

	public Wrapper<Provinces> retrievalConditionStructure(PageProvincesRequestVo provinces){
		final QueryWrapper<Provinces> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(provinces.getProvince())) {
			wrapper.like("province",provinces.getProvince());
        }

		if (StringUtils.isNotBlank(provinces.getProvinceid())){
			wrapper.like("provinceid",provinces.getProvinceid());
		}

		return wrapper;
	}
}

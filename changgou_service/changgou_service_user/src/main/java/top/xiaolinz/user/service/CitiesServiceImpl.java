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
import top.xiaolinz.user_api.entity.Cities;
import top.xiaolinz.user_api.entity.Cities;
import top.xiaolinz.user.mapper.CitiesMapper;
import top.xiaolinz.user_api.service.CitiesService;
import top.xiaolinz.user_api.vo.PageCitiesRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class CitiesServiceImpl extends ServiceImpl<CitiesMapper, Cities> implements CitiesService{
	@Override
	public List<Cities> findAll() {

		return this.list();
	}

	@Override
	public Cities findCitiesById(Integer id) {

		final Cities Cities = this.getById(id);
		return Cities;

	}

	@Override
	public void addCities(Cities cities) {
		this.save(cities);
	}

	@Override
	public void updateCities(Cities cities) {
		this.updateById(cities);
	}

	@Override
	public void deleteCities(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Cities> findCitiesByConditions(Cities cities) {
		if(cities == null){
			return new ArrayList<>();
		}

		final Wrapper<Cities> wrapper = this.retrievalConditionStructure(cities);


		final List<Cities> citiesList = this.list(wrapper);


		return citiesList;
	}

	@Override
	public PageResult<Cities> findByPage(PageCitiesRequestVo vo) {

		final HashMap<String, Object> citiesms = new HashMap<>();
		citiesms.put(PageConstant.PAGE,vo.getPage());
		citiesms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Cities> page = this.page(new Query<Cities>().getPage(citiesms),new QueryWrapper<Cities>());

		return new PageResult<Cities>(page);
	}

	@Override
	public PageResult<Cities> findByPageAndCondition(PageCitiesRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Cities> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Cities> page = this.page(new Query<Cities>().getPage(map), wrapper);

		return new PageResult<Cities>(page);
	}



	/**
	 * 多条件检索构造
	 * @param cities 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Cities> retrievalConditionStructure(Cities cities){
		final QueryWrapper<Cities> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(cities.getCity())) {
			wrapper.like("city",cities.getCity());
        }

		if (StringUtils.isNotBlank(cities.getProvinceid())) {
			wrapper.like("provinceid",cities.getProvinceid());
        }

		if (StringUtils.isNotBlank(cities.getCityid())) {
			wrapper.like("cityid",cities.getCityid());
        }

		return wrapper;
	}

	public Wrapper<Cities> retrievalConditionStructure(PageCitiesRequestVo cities){
		final QueryWrapper<Cities> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(cities.getCity())) {
			wrapper.like("city",cities.getCity());
		}

		if (StringUtils.isNotBlank(cities.getProvinceid())) {
			wrapper.like("provinceid",cities.getProvinceid());
		}

		if (StringUtils.isNotBlank(cities.getCityid())) {
			wrapper.like("cityid",cities.getCityid());
		}

		return wrapper;
	}
}

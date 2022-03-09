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
import top.xiaolinz.user_api.entity.Areas;
import top.xiaolinz.user_api.entity.Areas;
import top.xiaolinz.user.mapper.AreasMapper;
import top.xiaolinz.user_api.service.AreasService;
import top.xiaolinz.user_api.vo.PageAreasRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class AreasServiceImpl extends ServiceImpl<AreasMapper, Areas> implements AreasService{
	@Override
	public List<Areas> findAll() {

		return this.list();
	}

	@Override
	public Areas findAreasById(Integer id) {

		final Areas Areas = this.getById(id);
		return Areas;

	}

	@Override
	public void addAreas(Areas areas) {
		this.save(areas);
	}

	@Override
	public void updateAreas(Areas areas) {
		this.updateById(areas);
	}

	@Override
	public void deleteAreas(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Areas> findAreasByConditions(Areas areas) {
		if(areas == null){
			return new ArrayList<>();
		}

		final Wrapper<Areas> wrapper = this.retrievalConditionStructure(areas);


		final List<Areas> areasList = this.list(wrapper);


		return areasList;
	}

	@Override
	public PageResult<Areas> findByPage(PageAreasRequestVo vo) {

		final HashMap<String, Object> areasms = new HashMap<>();
		areasms.put(PageConstant.PAGE,vo.getPage());
		areasms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Areas> page = this.page(new Query<Areas>().getPage(areasms),new QueryWrapper<Areas>());

		return new PageResult<Areas>(page);
	}

	@Override
	public PageResult<Areas> findByPageAndCondition(PageAreasRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Areas> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Areas> page = this.page(new Query<Areas>().getPage(map), wrapper);

		return new PageResult<Areas>(page);
	}



	/**
	 * 多条件检索构造
	 * @param areas 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Areas> retrievalConditionStructure(Areas areas){
		final QueryWrapper<Areas> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(areas.getArea())) {
			wrapper.eq("area",areas.getArea());
		}

		if (StringUtils.isNotBlank(areas.getAreaid())) {
			wrapper.like("areaid",areas.getAreaid());
		}

		if (StringUtils.isNotBlank(areas.getCityid())){
			wrapper.like("cityid",areas.getCityid());
		}

		return wrapper;
	}

	public Wrapper<Areas> retrievalConditionStructure(PageAreasRequestVo areas){
		final QueryWrapper<Areas> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(areas.getArea())) {
			wrapper.eq("area",areas.getArea());
        }

		if (StringUtils.isNotBlank(areas.getAreaid())) {
			wrapper.like("areaid",areas.getAreaid());
        }

		if (StringUtils.isNotBlank(areas.getCityid())){
			wrapper.like("cityid",areas.getCityid());
		}

		return wrapper;
	}
}

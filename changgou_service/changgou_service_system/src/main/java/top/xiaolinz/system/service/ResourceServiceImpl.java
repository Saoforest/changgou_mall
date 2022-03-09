package top.xiaolinz.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.system.mapper.ResourceMapper;
import top.xiaolinz.system_api.entity.Resource;
import top.xiaolinz.system_api.entity.Resource;
import top.xiaolinz.system_api.service.ResourceService;
import top.xiaolinz.system_api.vo.PageResourceRequestVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService{
	@Override
	public List<Resource> findAll() {

		return this.list();
	}

	@Override
	public Resource findResourceById(Integer id) {

		final Resource Resource = this.getById(id);
		return Resource;

	}

	@Override
	public void addResource(Resource resource) {
		this.save(resource);
	}

	@Override
	public void updateResource(Resource resource) {
		this.updateById(resource);
	}

	@Override
	public void deleteResource(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Resource> findResourceByConditions(Resource resource) {
		if(resource == null){
			return new ArrayList<>();
		}

		final Wrapper<Resource> wrapper = this.retrievalConditionStructure(resource);


		final List<Resource> resourceList = this.list(wrapper);


		return resourceList;
	}

	@Override
	public PageResult<Resource> findByPage(PageResourceRequestVo vo) {

		final HashMap<String, Object> resourcems = new HashMap<>();
		resourcems.put(PageConstant.PAGE,vo.getPage());
		resourcems.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Resource> page = this.page(new Query<Resource>().getPage(resourcems),new QueryWrapper<Resource>());

		return new PageResult<Resource>(page);
	}

	@Override
	public PageResult<Resource> findByPageAndCondition(PageResourceRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Resource> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Resource> page = this.page(new Query<Resource>().getPage(map), wrapper);

		return new PageResult<Resource>(page);
	}



	/**
	 * 多条件检索构造
	 * @param resource 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Resource> retrievalConditionStructure(Resource resource){
		final QueryWrapper<Resource> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(resource.getResName())) {
			wrapper.like("res_name",resource.getResName());
		}

		if (StringUtils.isNotBlank(resource.getResKey())) {
			wrapper.like("res_key",resource.getResKey());
		}

		if (resource.getId() != null) {
			wrapper.eq("id", resource.getId());
		}
		if (resource.getParentId() != null) {
			wrapper.eq("parent_id",resource.getParentId());
		}

		return wrapper;
	}

	public Wrapper<Resource> retrievalConditionStructure(PageResourceRequestVo resource){
		final QueryWrapper<Resource> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(resource.getResName())) {
			wrapper.like("res_name",resource.getResName());
        }

		if (StringUtils.isNotBlank(resource.getResKey())) {
			wrapper.like("res_key",resource.getResKey());
        }

		if (resource.getId() != null) {
			wrapper.eq("id", resource.getId());
        }
		if (resource.getParentId() != null) {
			wrapper.eq("parent_id",resource.getParentId());
        }

		return wrapper;
	}
}

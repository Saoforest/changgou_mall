package top.xiaolinz.business.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.xiaolinz.business.mapper.ActivityMapper;
import top.xiaolinz.business_api.entity.Activity;
import top.xiaolinz.business_api.service.ActivityService;
import top.xiaolinz.business_api.vo.PageActivityRequestVo;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 23:20
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

	@Override
	public List<Activity> findAll() {

		return this.list();
	}

	@Override
	public Activity findActivityById(Integer id) {

		final Activity Activity = this.getById(id);
		return Activity;

	}

	@Override
	public void addActivity(Activity activity) {
		this.save(activity);
	}

	@Override
	public void updateActivity(Activity activity) {
		this.updateById(activity);
	}

	@Override
	public void deleteActivity(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Activity> findActivityByConditions(Activity activity) {
		if(activity == null){
			return new ArrayList<>();
		}

		final Wrapper<Activity> wrapper = this.retrievalConditionStructure(activity);


		final List<Activity> activityList = this.list(wrapper);


		return activityList;
	}

	@Override
	public PageResult<Activity> findByPage(PageActivityRequestVo vo) {

		final HashMap<String, Object> activityms = new HashMap<>();
		activityms.put(PageConstant.PAGE,vo.getPage());
		activityms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Activity> page = this.page(new Query<Activity>().getPage(activityms),new QueryWrapper<Activity>());

		return new PageResult<Activity>(page);
	}

	@Override
	public PageResult<Activity> findByPageAndCondition(PageActivityRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Activity> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Activity> page = this.page(new Query<Activity>().getPage(map), wrapper);

		return new PageResult<Activity>(page);
	}



	/**
	 * 多条件检索构造
	 * @param activity 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Activity> retrievalConditionStructure(Activity activity){
		final QueryWrapper<Activity> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(activity.getStatus())){
			wrapper.like("status",activity.getStatus());
		}

		if(StringUtils.isNotBlank(activity.getContent())){
			wrapper.like("content",activity.getContent());
		}

		if (StringUtils.isNotBlank(activity.getTitle())){
			wrapper.like("title",activity.getTitle());
		}

		if (activity.getId() != null) {
			wrapper.eq("id", activity.getId());
        }

		return wrapper;
	}

	public Wrapper<Activity> retrievalConditionStructure(PageActivityRequestVo activity){
		final QueryWrapper<Activity> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(activity.getStatus())){
			wrapper.like("status",activity.getStatus());
		}

		if(StringUtils.isNotBlank(activity.getContent())){
			wrapper.like("content",activity.getContent());
		}

		if (StringUtils.isNotBlank(activity.getTitle())){
			wrapper.like("title",activity.getTitle());
		}

		if (activity.getId() != null) {
			wrapper.eq("id", activity.getId());
		}

		return wrapper;
	}
}





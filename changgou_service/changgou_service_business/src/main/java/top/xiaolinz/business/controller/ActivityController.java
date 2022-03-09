package top.xiaolinz.business.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.business_api.entity.Activity;
import top.xiaolinz.business_api.service.ActivityService;
import top.xiaolinz.business_api.vo.PageActivityRequestVo;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:05
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/activity")
@Api(tags = {"活动接口"},value = "活动接口")
public class ActivityController {
	@Autowired
	private ActivityService activityService;

	/**
	 * 查询所有数据
	 * @return 数据集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有数据")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Activity> list = this.activityService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询数据
	 * @param activityId 数据id
	 * @return 数据对象
	 */
	@ApiOperation(value = "根据id查询数据")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "数据id",paramType = "path",name = "ActivityId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{ActivityId}")
	public R findById(@PathVariable("ActivityId") Integer activityId){
		final Activity activity = this.activityService.findActivityById(activityId);

		return R.ok(StatusCode.OK,"查询成功").put("data", activity);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加数据")
	public R addActivity(@RequestBody Activity activity){
		this.activityService.addActivity(activity);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改数据")
	public R updateActivity(@Validated(UpdateGroup.class) @RequestBody Activity activity){
		this.activityService.updateActivity(activity);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ActivityId}")
	@ApiOperation(value = "根据id删除数据")
	@ApiImplicitParams({@ApiImplicitParam(value = "数据id",paramType = "path",name = "ActivityId",required = true,dataTypeClass = Integer.class)})
	public R deleteActivity(@PathVariable("ActivityId") Integer activityId){
		this.activityService.deleteActivity(activityId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询数据")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findActivityByConditions(Activity activity){
		final List<Activity> activityList = this.activityService.findActivityByConditions(activity);

		return R.ok(StatusCode.OK,"查询成功").put("data",activityList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageActivityRequestVo activityVo){
		final PageResult<Activity> page = this.activityService.findByPage(activityVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageActivityRequestVo vo){
		final PageResult<Activity> data = this.activityService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

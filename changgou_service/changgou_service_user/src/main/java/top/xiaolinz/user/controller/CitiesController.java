package top.xiaolinz.user.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.user_api.entity.Cities;
import top.xiaolinz.user_api.service.CitiesService;
import top.xiaolinz.user_api.vo.PageCitiesRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/cities")
@Api(value = "cities接口",tags = {"cities接口" })
public class CitiesController {
	@Autowired
	private CitiesService citiesService;

	/**
	 * 查询所有cities
	 * @return cities集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有cities")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Cities> list = this.citiesService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询cities
	 * @citiesm citiesId citiesid
	 * @return cities对象
	 */
	@ApiOperation(value = "根据id查询cities")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "citiesId",paramType = "path",name = "CitiesId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{citiesId}")
	public R findById(@PathVariable("citiesId") Integer citiesId){
		final Cities cities = this.citiesService.findCitiesById(citiesId);

		return R.ok(StatusCode.OK,"查询成功").put("data", cities);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加cities")
	public R addCities(@RequestBody Cities cities){
		this.citiesService.addCities(cities);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改cities")
	public R updateCities(@Validated(UpdateGroup.class) @RequestBody Cities cities){
		this.citiesService.updateCities(cities);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{CitiesId}")
	@ApiOperation(value = "根据id删除cities")
	@ApiImplicitParams({@ApiImplicitParam(value = "citiesid" , paramType = "path",name = "CitiesId",required = true,dataTypeClass = Integer.class)})
	public R deleteCities(@PathVariable("CitiesId") Integer citiesId){
		this.citiesService.deleteCities(citiesId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询cities")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findCitiesByConditions(Cities cities){
		final List<Cities> CitiesList = this.citiesService.findCitiesByConditions(cities);

		return R.ok(StatusCode.OK,"查询成功").put("data",CitiesList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageCitiesRequestVo citiesVo){
		final PageResult<Cities> page = this.citiesService.findByPage(citiesVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageCitiesRequestVo vo){
		final PageResult<Cities> data = this.citiesService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

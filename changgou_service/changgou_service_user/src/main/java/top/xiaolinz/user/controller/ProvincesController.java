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
import top.xiaolinz.user_api.entity.Provinces;
import top.xiaolinz.user_api.service.ProvincesService;
import top.xiaolinz.user_api.vo.PageProvincesRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/provinces")
@Api(value = "provinces接口",tags = {"provinces接口" })
public class ProvincesController {
	@Autowired
	private ProvincesService provincesService;

	/**
	 * 查询所有provinces
	 * @return provinces集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有provinces")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Provinces> list = this.provincesService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询provinces
	 * @provincesm provincesId provincesid
	 * @return provinces对象
	 */
	@ApiOperation(value = "根据id查询provinces")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "provincesId",paramType = "path",name = "ProvincesId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{provincesId}")
	public R findById(@PathVariable("provincesId") Integer provincesId){
		final Provinces provinces = this.provincesService.findProvincesById(provincesId);

		return R.ok(StatusCode.OK,"查询成功").put("data", provinces);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加provinces")
	public R addProvinces(@RequestBody Provinces provinces){
		this.provincesService.addProvinces(provinces);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改provinces")
	public R updateProvinces(@Validated(UpdateGroup.class) @RequestBody Provinces provinces){
		this.provincesService.updateProvinces(provinces);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ProvincesId}")
	@ApiOperation(value = "根据id删除provinces")
	@ApiImplicitParams({@ApiImplicitParam(value = "provincesid" , paramType = "path",name = "ProvincesId",required = true,dataTypeClass = Integer.class)})
	public R deleteProvinces(@PathVariable("ProvincesId") Integer provincesId){
		this.provincesService.deleteProvinces(provincesId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询provinces")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findProvincesByConditions(Provinces provinces){
		final List<Provinces> ProvincesList = this.provincesService.findProvincesByConditions(provinces);

		return R.ok(StatusCode.OK,"查询成功").put("data",ProvincesList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageProvincesRequestVo provincesVo){
		final PageResult<Provinces> page = this.provincesService.findByPage(provincesVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageProvincesRequestVo vo){
		final PageResult<Provinces> data = this.provincesService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

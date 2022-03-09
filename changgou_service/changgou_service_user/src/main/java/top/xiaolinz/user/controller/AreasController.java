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
import top.xiaolinz.user_api.entity.Areas;
import top.xiaolinz.user_api.service.AreasService;
import top.xiaolinz.user_api.vo.PageAreasRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/areas")
@Api(value = "areas接口",tags = {"areas接口" })
public class AreasController {
	@Autowired
	private AreasService areasService;

	/**
	 * 查询所有areas
	 * @return areas集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有areas")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Areas> list = this.areasService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询areas
	 * @areasm areasId areasid
	 * @return areas对象
	 */
	@ApiOperation(value = "根据id查询areas")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "areasId",paramType = "path",name = "AreasId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{areasId}")
	public R findById(@PathVariable("areasId") Integer areasId){
		final Areas areas = this.areasService.findAreasById(areasId);

		return R.ok(StatusCode.OK,"查询成功").put("data", areas);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加areas")
	public R addAreas(@RequestBody Areas areas){
		this.areasService.addAreas(areas);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改areas")
	public R updateAreas(@Validated(UpdateGroup.class) @RequestBody Areas areas){
		this.areasService.updateAreas(areas);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{AreasId}")
	@ApiOperation(value = "根据id删除areas")
	@ApiImplicitParams({@ApiImplicitParam(value = "areasid" , paramType = "path",name = "AreasId",required = true,dataTypeClass = Integer.class)})
	public R deleteAreas(@PathVariable("AreasId") Integer areasId){
		this.areasService.deleteAreas(areasId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询areas")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findAreasByConditions(Areas areas){
		final List<Areas> AreasList = this.areasService.findAreasByConditions(areas);

		return R.ok(StatusCode.OK,"查询成功").put("data",AreasList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageAreasRequestVo areasVo){
		final PageResult<Areas> page = this.areasService.findByPage(areasVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageAreasRequestVo vo){
		final PageResult<Areas> data = this.areasService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

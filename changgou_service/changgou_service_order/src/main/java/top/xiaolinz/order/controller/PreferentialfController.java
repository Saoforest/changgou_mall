package top.xiaolinz.order.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.Preferential;
import top.xiaolinz.order_api.service.PreferentialService;
import top.xiaolinz.order_api.vo.PagePreferentialRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/preferential")
@Api(value = "preferential接口",tags = {"preferential接口" })
public class PreferentialfController {
	@Autowired
	private PreferentialService preferentialService;

	/**
	 * 查询所有preferential
	 * @return preferential集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有preferential")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Preferential> list = this.preferentialService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询preferential
	 * @preferentialm preferentialId preferentialid
	 * @return preferential对象
	 */
	@ApiOperation(value = "根据id查询preferential")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "preferentialId",paramType = "path",name = "PreferentialId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{preferentialId}")
	public R findById(@PathVariable("preferentialId") Integer preferentialId){
		final Preferential preferential = this.preferentialService.findPreferentialById(preferentialId);

		return R.ok(StatusCode.OK,"查询成功").put("data", preferential);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加preferential")
	public R addPreferential(@RequestBody Preferential preferential){
		this.preferentialService.addPreferential(preferential);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改preferential")
	public R updatePreferential(@Validated(UpdateGroup.class) @RequestBody Preferential preferential){
		this.preferentialService.updatePreferential(preferential);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{PreferentialId}")
	@ApiOperation(value = "根据id删除preferential")
	@ApiImplicitParams({@ApiImplicitParam(value = "preferentialid" , paramType = "path",name = "PreferentialId",required = true,dataTypeClass = Integer.class)})
	public R deletePreferential(@PathVariable("PreferentialId") Integer preferentialId){
		this.preferentialService.deletePreferential(preferentialId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询preferential")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findPreferentialByConditions(Preferential preferential){
		final List<Preferential> PreferentialList = this.preferentialService.findPreferentialByConditions(preferential);

		return R.ok(StatusCode.OK,"查询成功").put("data",PreferentialList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PagePreferentialRequestVo preferentialVo){
		final PageResult<Preferential> page = this.preferentialService.findByPage(preferentialVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PagePreferentialRequestVo vo){
		final PageResult<Preferential> data = this.preferentialService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

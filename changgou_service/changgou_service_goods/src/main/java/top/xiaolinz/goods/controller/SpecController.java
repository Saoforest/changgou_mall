package top.xiaolinz.goods.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Spec;
import top.xiaolinz.goods_api.service.SpecService;
import top.xiaolinz.goods_api.vo.PageSpecRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 15:05
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/spec")
@Api(tags = "规格接口",value = "规格管理")
@CrossOrigin
public class SpecController {

	@Autowired
	private SpecService specService;

	/**
	 * 查询所有规格
	 * @return 规格集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有规格")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Spec> list = this.specService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询规格
	 * @param specId 规格id
	 * @return 规格对象
	 */
	@ApiOperation(value = "根据id查询规格")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "规格id",paramType = "path",name = "SpecId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{SpecId}")
	public R findById(@PathVariable("SpecId") Integer specId){
		final Spec spec = this.specService.findSpecById(specId);

		return R.ok(StatusCode.OK,"查询成功").put("data", spec);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加规格")
	public R addSpec(@RequestBody Spec spec){
		this.specService.addSpec(spec);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改规格")
	public R updateSpec(@Validated(UpdateGroup.class) @RequestBody Spec spec){
		this.specService.updateSpec(spec);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{SpecId}")
	@ApiOperation(value = "根据id删除规格")
	@ApiImplicitParams({@ApiImplicitParam(value = "规格id",paramType = "path",name = "SpecId",required = true,dataTypeClass = Integer.class)})
	public R deleteSpec(@PathVariable("SpecId") Integer specId){
		this.specService.deleteSpec(specId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询规格")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findSpecByConditions(Spec spec){
		final List<Spec> specList = this.specService.findSpecByConditions(spec);

		return R.ok(StatusCode.OK,"查询成功").put("data",specList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageSpecRequestVo specVo){
		final PageResult<Spec> page = this.specService.findByPage(specVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageSpecRequestVo vo){
		final PageResult<Spec> data = this.specService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}


}

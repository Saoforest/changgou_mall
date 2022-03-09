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
import top.xiaolinz.goods_api.entity.Para;
import top.xiaolinz.goods_api.service.ParaService;
import top.xiaolinz.goods_api.vo.PageParaRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/para")
@Api(value = "属性接口",tags = {"属性接口" })
public class ParaController {
	@Autowired
	private ParaService paraService;

	/**
	 * 查询所有属性
	 * @return 属性集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有属性")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Para> list = this.paraService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询属性
	 * @param paraId 属性id
	 * @return 属性对象
	 */
	@ApiOperation(value = "根据id查询属性")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "属性id",paramType = "path",name = "ParaId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{ParaId}")
	public R findById(@PathVariable("ParaId") Integer paraId){
		final Para para = this.paraService.findParaById(paraId);

		return R.ok(StatusCode.OK,"查询成功").put("data", para);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加属性")
	public R addPara(@RequestBody Para para){
		this.paraService.addPara(para);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改属性")
	public R updatePara(@Validated(UpdateGroup.class) @RequestBody Para para){
		this.paraService.updatePara(para);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ParaId}")
	@ApiOperation(value = "根据id删除属性")
	@ApiImplicitParams({@ApiImplicitParam(value = "属性id",paramType = "path",name = "ParaId",required = true,dataTypeClass = Integer.class)})
	public R deletePara(@PathVariable("ParaId") Integer paraId){
		this.paraService.deletePara(paraId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询属性")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findParaByConditions(Para para){
		final List<Para> paraList = this.paraService.findParaByConditions(para);

		return R.ok(StatusCode.OK,"查询成功").put("data",paraList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageParaRequestVo paraVo){
		final PageResult<Para> page = this.paraService.findByPage(paraVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageParaRequestVo vo){
		final PageResult<Para> data = this.paraService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

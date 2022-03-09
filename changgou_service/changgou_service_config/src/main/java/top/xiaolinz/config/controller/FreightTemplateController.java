package top.xiaolinz.config.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.config_api.entity.FreightTemplate;
import top.xiaolinz.config_api.service.FreightTemplateService;
import top.xiaolinz.config_api.vo.PageFreightTemplateRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:05
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/freightTemplate")
@Api(tags = {"货运模板接口"},value = "货运模板接口")
public class FreightTemplateController {
	@Autowired
	private FreightTemplateService freightTemplateService;

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
		final List<FreightTemplate> list = this.freightTemplateService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询数据
	 * @param freightTemplateId 数据id
	 * @return 数据对象
	 */
	@ApiOperation(value = "根据id查询数据")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "数据id",paramType = "path",name = "FreightTemplateId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{FreightTemplateId}")
	public R findById(@PathVariable("FreightTemplateId") Integer freightTemplateId){
		final FreightTemplate freightTemplate = this.freightTemplateService.findFreightTemplateById(freightTemplateId);

		return R.ok(StatusCode.OK,"查询成功").put("data", freightTemplate);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加数据")
	public R addFreightTemplate(@RequestBody FreightTemplate freightTemplate){
		this.freightTemplateService.addFreightTemplate(freightTemplate);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改数据")
	public R updateFreightTemplate(@Validated(UpdateGroup.class) @RequestBody FreightTemplate freightTemplate){
		this.freightTemplateService.updateFreightTemplate(freightTemplate);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{FreightTemplateId}")
	@ApiOperation(value = "根据id删除数据")
	@ApiImplicitParams({@ApiImplicitParam(value = "数据id",paramType = "path",name = "FreightTemplateId",required = true,dataTypeClass = Integer.class)})
	public R deleteFreightTemplate(@PathVariable("FreightTemplateId") Integer freightTemplateId){
		this.freightTemplateService.deleteFreightTemplate(freightTemplateId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询数据")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findFreightTemplateByConditions(FreightTemplate freightTemplate){
		final List<FreightTemplate> freightTemplateList = this.freightTemplateService.findFreightTemplateByConditions(freightTemplate);

		return R.ok(StatusCode.OK,"查询成功").put("data",freightTemplateList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageFreightTemplateRequestVo freightTemplateVo){
		final PageResult<FreightTemplate> page = this.freightTemplateService.findByPage(freightTemplateVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageFreightTemplateRequestVo vo){
		final PageResult<FreightTemplate> data = this.freightTemplateService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

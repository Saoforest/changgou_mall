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
import top.xiaolinz.goods_api.entity.Template;
import top.xiaolinz.goods_api.service.TemplateService;
import top.xiaolinz.goods_api.vo.PageTemplateRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/template")
@Api(value = "template接口",tags = {"模板接口" })
public class TemplatefController {
	@Autowired
	private TemplateService templateService;

	/**
	 * 查询所有template
	 * @return template集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有template")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Template> list = this.templateService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询template
	 * @templatem templateId templateid
	 * @return template对象
	 */
	@ApiOperation(value = "根据id查询template")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "templateId",paramType = "path",name = "TemplateId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{templateId}")
	public R findById(@PathVariable("templateId") Integer templateId){
		final Template template = this.templateService.findTemplateById(templateId);

		return R.ok(StatusCode.OK,"查询成功").put("data", template);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加template")
	public R addTemplate(@RequestBody Template template){
		this.templateService.addTemplate(template);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改template")
	public R updateTemplate(@Validated(UpdateGroup.class) @RequestBody Template template){
		this.templateService.updateTemplate(template);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{TemplateId}")
	@ApiOperation(value = "根据id删除template")
	@ApiImplicitParams({@ApiImplicitParam(value = "templateid" , paramType = "path",name = "TemplateId",required = true,dataTypeClass = Integer.class)})
	public R deleteTemplate(@PathVariable("TemplateId") Integer templateId){
		this.templateService.deleteTemplate(templateId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询template")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findTemplateByConditions(Template template){
		final List<Template> TemplateList = this.templateService.findTemplateByConditions(template);

		return R.ok(StatusCode.OK,"查询成功").put("data",TemplateList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageTemplateRequestVo templateVo){
		final PageResult<Template> page = this.templateService.findByPage(templateVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageTemplateRequestVo vo){
		final PageResult<Template> data = this.templateService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

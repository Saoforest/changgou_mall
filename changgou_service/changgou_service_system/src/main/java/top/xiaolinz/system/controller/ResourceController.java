package top.xiaolinz.system.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.system_api.entity.Resource;
import top.xiaolinz.system_api.service.ResourceService;
import top.xiaolinz.system_api.vo.PageResourceRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/resource")
@Api(value = "resource接口",tags = {"resource接口" })
public class ResourceController {
	@Autowired
	private ResourceService resourceService;

	/**
	 * 查询所有resource
	 * @return resource集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有resource")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Resource> list = this.resourceService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询resource
	 * @resourcem resourceId resourceid
	 * @return resource对象
	 */
	@ApiOperation(value = "根据id查询resource")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "resourceId",paramType = "path",name = "ResourceId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{resourceId}")
	public R findById(@PathVariable("resourceId") Integer resourceId){
		final Resource resource = this.resourceService.findResourceById(resourceId);

		return R.ok(StatusCode.OK,"查询成功").put("data", resource);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加resource")
	public R addResource(@RequestBody Resource resource){
		this.resourceService.addResource(resource);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改resource")
	public R updateResource(@Validated(UpdateGroup.class) @RequestBody Resource resource){
		this.resourceService.updateResource(resource);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ResourceId}")
	@ApiOperation(value = "根据id删除resource")
	@ApiImplicitParams({@ApiImplicitParam(value = "resourceid" , paramType = "path",name = "ResourceId",required = true,dataTypeClass = Integer.class)})
	public R deleteResource(@PathVariable("ResourceId") Integer resourceId){
		this.resourceService.deleteResource(resourceId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询resource")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findResourceByConditions(Resource resource){
		final List<Resource> ResourceList = this.resourceService.findResourceByConditions(resource);

		return R.ok(StatusCode.OK,"查询成功").put("data",ResourceList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageResourceRequestVo resourceVo){
		final PageResult<Resource> page = this.resourceService.findByPage(resourceVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageResourceRequestVo vo){
		final PageResult<Resource> data = this.resourceService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

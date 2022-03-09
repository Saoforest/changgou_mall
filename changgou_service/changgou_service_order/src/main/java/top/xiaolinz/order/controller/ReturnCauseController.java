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
import top.xiaolinz.order_api.entity.ReturnCause;
import top.xiaolinz.order_api.service.ReturnCauseService;
import top.xiaolinz.order_api.vo.PageReturnCauseRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/returnCause")
@Api(value = "returnCause接口",tags = {"returnCause接口" })
public class ReturnCauseController {
	@Autowired
	private ReturnCauseService returnCauseService;

	/**
	 * 查询所有returnCause
	 * @return returnCause集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有returnCause")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<ReturnCause> list = this.returnCauseService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询returnCause
	 * @returnCausem returnCauseId returnCauseid
	 * @return returnCause对象
	 */
	@ApiOperation(value = "根据id查询returnCause")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "returnCauseId",paramType = "path",name = "ReturnCauseId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{returnCauseId}")
	public R findById(@PathVariable("returnCauseId") Integer returnCauseId){
		final ReturnCause returnCause = this.returnCauseService.findReturnCauseById(returnCauseId);

		return R.ok(StatusCode.OK,"查询成功").put("data", returnCause);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加returnCause")
	public R addReturnCause(@RequestBody ReturnCause returnCause){
		this.returnCauseService.addReturnCause(returnCause);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改returnCause")
	public R updateReturnCause(@Validated(UpdateGroup.class) @RequestBody ReturnCause returnCause){
		this.returnCauseService.updateReturnCause(returnCause);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ReturnCauseId}")
	@ApiOperation(value = "根据id删除returnCause")
	@ApiImplicitParams({@ApiImplicitParam(value = "returnCauseid" , paramType = "path",name = "ReturnCauseId",required = true,dataTypeClass = Integer.class)})
	public R deleteReturnCause(@PathVariable("ReturnCauseId") Integer returnCauseId){
		this.returnCauseService.deleteReturnCause(returnCauseId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询returnCause")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findReturnCauseByConditions(ReturnCause returnCause){
		final List<ReturnCause> ReturnCauseList = this.returnCauseService.findReturnCauseByConditions(returnCause);

		return R.ok(StatusCode.OK,"查询成功").put("data",ReturnCauseList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageReturnCauseRequestVo returnCauseVo){
		final PageResult<ReturnCause> page = this.returnCauseService.findByPage(returnCauseVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageReturnCauseRequestVo vo){
		final PageResult<ReturnCause> data = this.returnCauseService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

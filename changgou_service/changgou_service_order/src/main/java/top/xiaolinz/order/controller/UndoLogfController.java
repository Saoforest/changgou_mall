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
import top.xiaolinz.order_api.entity.UndoLog;
import top.xiaolinz.order_api.service.UndoLogService;
import top.xiaolinz.order_api.vo.PageUndoLogRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/undoLog")
@Api(value = "undoLog接口",tags = {"undoLog接口" })
public class UndoLogfController {
	@Autowired
	private UndoLogService undoLogService;

	/**
	 * 查询所有undoLog
	 * @return undoLog集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有undoLog")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<UndoLog> list = this.undoLogService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询undoLog
	 * @undoLogm undoLogId undoLogid
	 * @return undoLog对象
	 */
	@ApiOperation(value = "根据id查询undoLog")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "undoLogId",paramType = "path",name = "UndoLogId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{undoLogId}")
	public R findById(@PathVariable("undoLogId") Integer undoLogId){
		final UndoLog undoLog = this.undoLogService.findUndoLogById(undoLogId);

		return R.ok(StatusCode.OK,"查询成功").put("data", undoLog);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加undoLog")
	public R addUndoLog(@RequestBody UndoLog undoLog){
		this.undoLogService.addUndoLog(undoLog);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改undoLog")
	public R updateUndoLog(@Validated(UpdateGroup.class) @RequestBody UndoLog undoLog){
		this.undoLogService.updateUndoLog(undoLog);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{UndoLogId}")
	@ApiOperation(value = "根据id删除undoLog")
	@ApiImplicitParams({@ApiImplicitParam(value = "undoLogid" , paramType = "path",name = "UndoLogId",required = true,dataTypeClass = Integer.class)})
	public R deleteUndoLog(@PathVariable("UndoLogId") Integer undoLogId){
		this.undoLogService.deleteUndoLog(undoLogId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询undoLog")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findUndoLogByConditions(UndoLog undoLog){
		final List<UndoLog> UndoLogList = this.undoLogService.findUndoLogByConditions(undoLog);

		return R.ok(StatusCode.OK,"查询成功").put("data",UndoLogList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageUndoLogRequestVo undoLogVo){
		final PageResult<UndoLog> page = this.undoLogService.findByPage(undoLogVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageUndoLogRequestVo vo){
		final PageResult<UndoLog> data = this.undoLogService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

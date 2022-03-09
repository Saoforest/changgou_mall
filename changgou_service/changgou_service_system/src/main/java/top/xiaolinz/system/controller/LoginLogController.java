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
import top.xiaolinz.system_api.entity.LoginLog;
import top.xiaolinz.system_api.service.LoginLogService;
import top.xiaolinz.system_api.vo.PageLoginLogRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/loginLog")
@Api(value = "loginLog接口",tags = {"loginLog接口" })
public class LoginLogController {
	@Autowired
	private LoginLogService loginLogService;

	/**
	 * 查询所有loginLog
	 * @return loginLog集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有loginLog")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<LoginLog> list = this.loginLogService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询loginLog
	 * @loginLogm loginLogId loginLogid
	 * @return loginLog对象
	 */
	@ApiOperation(value = "根据id查询loginLog")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "loginLogId",paramType = "path",name = "LoginLogId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{loginLogId}")
	public R findById(@PathVariable("loginLogId") Integer loginLogId){
		final LoginLog loginLog = this.loginLogService.findLoginLogById(loginLogId);

		return R.ok(StatusCode.OK,"查询成功").put("data", loginLog);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加loginLog")
	public R addLoginLog(@RequestBody LoginLog loginLog){
		this.loginLogService.addLoginLog(loginLog);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改loginLog")
	public R updateLoginLog(@Validated(UpdateGroup.class) @RequestBody LoginLog loginLog){
		this.loginLogService.updateLoginLog(loginLog);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{LoginLogId}")
	@ApiOperation(value = "根据id删除loginLog")
	@ApiImplicitParams({@ApiImplicitParam(value = "loginLogid" , paramType = "path",name = "LoginLogId",required = true,dataTypeClass = Integer.class)})
	public R deleteLoginLog(@PathVariable("LoginLogId") Integer loginLogId){
		this.loginLogService.deleteLoginLog(loginLogId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询loginLog")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findLoginLogByConditions(LoginLog loginLog){
		final List<LoginLog> LoginLogList = this.loginLogService.findLoginLogByConditions(loginLog);

		return R.ok(StatusCode.OK,"查询成功").put("data",LoginLogList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageLoginLogRequestVo loginLogVo){
		final PageResult<LoginLog> page = this.loginLogService.findByPage(loginLogVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageLoginLogRequestVo vo){
		final PageResult<LoginLog> data = this.loginLogService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

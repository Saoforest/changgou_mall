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
import top.xiaolinz.user_api.entity.User;
import top.xiaolinz.user_api.service.UserService;
import top.xiaolinz.user_api.vo.PageUserRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/user")
@Api(value = "user接口",tags = {"user接口" })
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 查询所有user
	 * @return user集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有user")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<User> list = this.userService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询user
	 * @userm userId userid
	 * @return user对象
	 */
	@ApiOperation(value = "根据id查询user")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "userId",paramType = "path",name = "UserId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{userId}")
	public R findById(@PathVariable("userId") Integer userId){
		final User user = this.userService.findUserById(userId);

		return R.ok(StatusCode.OK,"查询成功").put("data", user);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加user")
	public R addUser(@RequestBody User user){
		this.userService.addUser(user);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改user")
	public R updateUser(@Validated(UpdateGroup.class) @RequestBody User user){
		this.userService.updateUser(user);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{UserId}")
	@ApiOperation(value = "根据id删除user")
	@ApiImplicitParams({@ApiImplicitParam(value = "userid" , paramType = "path",name = "UserId",required = true,dataTypeClass = Integer.class)})
	public R deleteUser(@PathVariable("UserId") Integer userId){
		this.userService.deleteUser(userId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询user")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findUserByConditions(User user){
		final List<User> UserList = this.userService.findUserByConditions(user);

		return R.ok(StatusCode.OK,"查询成功").put("data",UserList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageUserRequestVo userVo){
		final PageResult<User> page = this.userService.findByPage(userVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageUserRequestVo vo){
		final PageResult<User> data = this.userService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

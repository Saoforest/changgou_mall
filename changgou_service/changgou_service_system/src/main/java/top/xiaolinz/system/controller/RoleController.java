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
import top.xiaolinz.system_api.entity.Role;
import top.xiaolinz.system_api.service.RoleService;
import top.xiaolinz.system_api.vo.PageRoleRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/role")
@Api(value = "role接口",tags = {"role接口" })
public class RoleController {
	@Autowired
	private RoleService roleService;

	/**
	 * 查询所有role
	 * @return role集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有role")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Role> list = this.roleService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询role
	 * @rolem roleId roleid
	 * @return role对象
	 */
	@ApiOperation(value = "根据id查询role")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "roleId",paramType = "path",name = "RoleId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{roleId}")
	public R findById(@PathVariable("roleId") Integer roleId){
		final Role role = this.roleService.findRoleById(roleId);

		return R.ok(StatusCode.OK,"查询成功").put("data", role);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加role")
	public R addRole(@RequestBody Role role){
		this.roleService.addRole(role);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改role")
	public R updateRole(@Validated(UpdateGroup.class) @RequestBody Role role){
		this.roleService.updateRole(role);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{RoleId}")
	@ApiOperation(value = "根据id删除role")
	@ApiImplicitParams({@ApiImplicitParam(value = "roleid" , paramType = "path",name = "RoleId",required = true,dataTypeClass = Integer.class)})
	public R deleteRole(@PathVariable("RoleId") Integer roleId){
		this.roleService.deleteRole(roleId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询role")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findRoleByConditions(Role role){
		final List<Role> RoleList = this.roleService.findRoleByConditions(role);

		return R.ok(StatusCode.OK,"查询成功").put("data",RoleList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageRoleRequestVo roleVo){
		final PageResult<Role> page = this.roleService.findByPage(roleVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageRoleRequestVo vo){
		final PageResult<Role> data = this.roleService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

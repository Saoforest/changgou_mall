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
import top.xiaolinz.system_api.entity.Admin;
import top.xiaolinz.system_api.service.AdminService;
import top.xiaolinz.system_api.vo.PageAdminRequestVo;
import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/admin")
@Api(value = "admin接口",tags = {"admin接口" })
public class AdminController {
	@Autowired
	private AdminService adminService;

	/**
	 * 查询所有admin
	 * @return admin集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有admin")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Admin> list = this.adminService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询admin
	 * @adminm adminId adminid
	 * @return admin对象
	 */
	@ApiOperation(value = "根据id查询admin")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "adminId",paramType = "path",name = "AdminId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{adminId}")
	public R findById(@PathVariable("adminId") Integer adminId){
		final Admin admin = this.adminService.findAdminById(adminId);

		return R.ok(StatusCode.OK,"查询成功").put("data", admin);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加admin")
	public R addAdmin(@RequestBody Admin admin){
		this.adminService.addAdmin(admin);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改admin")
	public R updateAdmin(@Validated(UpdateGroup.class) @RequestBody Admin admin){
		this.adminService.updateAdmin(admin);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{AdminId}")
	@ApiOperation(value = "根据id删除admin")
	@ApiImplicitParams({@ApiImplicitParam(value = "adminid" , paramType = "path",name = "AdminId",required = true,dataTypeClass = Integer.class)})
	public R deleteAdmin(@PathVariable("AdminId") Integer adminId){
		this.adminService.deleteAdmin(adminId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询admin")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findAdminByConditions(Admin admin){
		final List<Admin> AdminList = this.adminService.findAdminByConditions(admin);

		return R.ok(StatusCode.OK,"查询成功").put("data",AdminList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageAdminRequestVo adminVo){
		final PageResult<Admin> page = this.adminService.findByPage(adminVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageAdminRequestVo vo){
		final PageResult<Admin> data = this.adminService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

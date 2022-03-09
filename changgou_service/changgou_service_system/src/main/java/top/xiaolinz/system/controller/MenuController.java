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
import top.xiaolinz.system_api.entity.Menu;
import top.xiaolinz.system_api.service.MenuService;
import top.xiaolinz.system_api.vo.PageMenuRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/menu")
@Api(value = "menu接口",tags = {"menu接口" })
public class MenuController {
	@Autowired
	private MenuService menuService;

	/**
	 * 查询所有menu
	 * @return menu集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有menu")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Menu> list = this.menuService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询menu
	 * @menum menuId menuid
	 * @return menu对象
	 */
	@ApiOperation(value = "根据id查询menu")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "menuId",paramType = "path",name = "MenuId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{menuId}")
	public R findById(@PathVariable("menuId") Integer menuId){
		final Menu menu = this.menuService.findMenuById(menuId);

		return R.ok(StatusCode.OK,"查询成功").put("data", menu);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加menu")
	public R addMenu(@RequestBody Menu menu){
		this.menuService.addMenu(menu);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改menu")
	public R updateMenu(@Validated(UpdateGroup.class) @RequestBody Menu menu){
		this.menuService.updateMenu(menu);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{MenuId}")
	@ApiOperation(value = "根据id删除menu")
	@ApiImplicitParams({@ApiImplicitParam(value = "menuid" , paramType = "path",name = "MenuId",required = true,dataTypeClass = Integer.class)})
	public R deleteMenu(@PathVariable("MenuId") Integer menuId){
		this.menuService.deleteMenu(menuId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询menu")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findMenuByConditions(Menu menu){
		final List<Menu> MenuList = this.menuService.findMenuByConditions(menu);

		return R.ok(StatusCode.OK,"查询成功").put("data",MenuList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageMenuRequestVo menuVo){
		final PageResult<Menu> page = this.menuService.findByPage(menuVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageMenuRequestVo vo){
		final PageResult<Menu> data = this.menuService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

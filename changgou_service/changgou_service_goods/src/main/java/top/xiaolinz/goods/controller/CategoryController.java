package top.xiaolinz.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Category;
import top.xiaolinz.goods_api.service.CategoryService;
import top.xiaolinz.goods_api.vo.PageCategoryRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/category")
@Api(value = "分类接口",tags = {"分类接口"})
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

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
		final List<Category> list = this.categoryService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询数据
	 * @param categoryId 数据id
	 * @return 数据对象
	 */
	@ApiOperation(value = "根据id查询数据")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "数据id",paramType = "path",name = "CategoryId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{CategoryId}")
	public R findById(@PathVariable("CategoryId") Integer categoryId){
		final Category category = this.categoryService.findCategoryById(categoryId);

		return R.ok(StatusCode.OK,"查询成功").put("data", category);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加数据")
	public R addCategory(@RequestBody Category category){
		this.categoryService.addCategory(category);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改数据")
	public R updateCategory(@Validated(UpdateGroup.class) @RequestBody Category category){
		this.categoryService.updateCategory(category);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{CategoryId}")
	@ApiOperation(value = "根据id删除数据")
	@ApiImplicitParams({@ApiImplicitParam(value = "数据id",paramType = "path",name = "CategoryId",required = true,dataTypeClass = Integer.class)})
	public R deleteCategory(@PathVariable("CategoryId") Integer categoryId){
		this.categoryService.deleteCategory(categoryId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询数据")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findCategoryByConditions(Category category){
		final List<Category> categoryList = this.categoryService.findCategoryByConditions(category);

		return R.ok(StatusCode.OK,"查询成功").put("data",categoryList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageCategoryRequestVo categoryVo){
		final PageResult<Category> page = this.categoryService.findByPage(categoryVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageCategoryRequestVo vo){
		final PageResult<Category> data = this.categoryService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

package top.xiaolinz.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.goods_api.entity.Brand;
import top.xiaolinz.goods_api.service.BrandService;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:51
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@Api(tags = "品牌接口",value = "品牌管理")
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	BrandService brandService;

	/**
	 * 查询所有品牌
	 * @return 品牌集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有品牌",httpMethod = "GET")
	public R findAll(){
		final List<Brand> list = brandService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询品牌
	 * @param brandId 品牌id
	 * @return 品牌对象
	 */
	@ApiOperation(value = "根据id查询品牌",httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "品牌id",paramType = "path",name = "id",required = true,dataType = "int",defaultValue = "1115")
	})
	@GetMapping("/{id}")
	public R findById(@PathVariable("id") Integer brandId){
		final Brand brand = this.brandService.findBrandById(brandId);

		return R.ok(StatusCode.OK,"查询成功").put("data", brand);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加品牌",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "品牌对象",paramType = "body",name = "brand",required = true,dataType = "Brand")
	})
	public R addBrand(@RequestBody Brand brand){
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改品牌",httpMethod = "PUT")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "修改的品牌信息对象",paramType = "body",name = "brand",required = true,dataType = "Brand")
	})
	public R updateBrand(@Validated(UpdateGroup.class) @RequestBody Brand brand){
		this.brandService.updateBrand(brand);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{brandId}")
	@ApiOperation(value = "根据id删除品牌",httpMethod = "DELETE")
	@ApiImplicitParams({@ApiImplicitParam(value = "品牌id",paramType = "path",name = "brandId",required = true,dataType = "int")})
	public R deleteBrand(@PathVariable("brandId") Integer brandId){
		this.brandService.deleteBrand(brandId);

		return R.ok(StatusCode.OK, "删除成功");
	}
}

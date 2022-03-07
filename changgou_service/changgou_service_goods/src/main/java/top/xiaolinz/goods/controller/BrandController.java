package top.xiaolinz.goods.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.vo.PageBrandRequestVo;
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
	@ApiOperation(value = "查询所有品牌")
	public R findAll(){
		final List<Brand> list = brandService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询品牌
	 * @param brandId 品牌id
	 * @return 品牌对象
	 */
	@ApiOperation(value = "根据id查询品牌")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "品牌id",paramType = "path",name = "brandId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{brandId}")
	public R findById(@PathVariable("brandId") Integer brandId){
		final Brand brand = this.brandService.findBrandById(brandId);

		return R.ok(StatusCode.OK,"查询成功").put("data", brand);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加品牌")
	public R addBrand(@RequestBody Brand brand){
		this.brandService.addBrand(brand);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改品牌")
	public R updateBrand(@Validated(UpdateGroup.class) @RequestBody Brand brand){
		this.brandService.updateBrand(brand);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{brandId}")
	@ApiOperation(value = "根据id删除品牌")
	@ApiImplicitParams({@ApiImplicitParam(value = "品牌id",paramType = "path",name = "brandId",required = true,dataTypeClass = Integer.class)})
	public R deleteBrand(@PathVariable("brandId") Integer brandId){
		this.brandService.deleteBrand(brandId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询品牌")
	public R findBrandByConditions(@RequestParam Brand brand){
		final List<Brand> brandList = this.brandService.findBrandByConditions(brand);

		return R.ok(StatusCode.OK,"查询成功").put("data",brandList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(@RequestParam PageBrandRequestVo brandVo){
		final PageResult<Brand> page = this.brandService.findByPage(brandVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	public R findByPageAndConditions(@RequestParam PageBrandRequestVo vo){
		final PageResult<Brand> data = this.brandService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

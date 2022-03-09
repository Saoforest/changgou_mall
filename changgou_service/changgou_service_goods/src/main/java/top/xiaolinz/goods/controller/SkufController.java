package top.xiaolinz.goods.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.service.SkuService;
import top.xiaolinz.goods_api.vo.PageSkuRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/sku")
@Api(value = "Sku接口",tags = {"Sku接口" })
public class SkufController {
	@Autowired
	private SkuService skuService;

	/**
	 * 查询所有Sku
	 * @return Sku集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有Sku")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Sku> list = this.skuService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询Sku
	 * @skum skuId Skuid
	 * @return Sku对象
	 */
	@ApiOperation(value = "根据id查询Sku")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "Skuid",paramType = "path",name = "SkuId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{skuId}")
	public R findById(@PathVariable("skuId") Integer skuId){
		final Sku sku = this.skuService.findSkuById(skuId);

		return R.ok(StatusCode.OK,"查询成功").put("data", sku);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加Sku")
	public R addSku(@RequestBody Sku sku){
		this.skuService.addSku(sku);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改Sku")
	public R updateSku(@Validated(UpdateGroup.class) @RequestBody Sku sku){
		this.skuService.updateSku(sku);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{SkuId}")
	@ApiOperation(value = "根据id删除Sku")
	@ApiImplicitParams({@ApiImplicitParam(value = "Skuid" , paramType = "path",name = "SkuId",required = true,dataTypeClass = Integer.class)})
	public R deleteSku(@PathVariable("SkuId") Integer skuId){
		this.skuService.deleteSku(skuId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询Sku")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findSkuByConditions(Sku sku){
		final List<Sku> SkuList = this.skuService.findSkuByConditions(sku);

		return R.ok(StatusCode.OK,"查询成功").put("data",SkuList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageSkuRequestVo skuVo){
		final PageResult<Sku> page = this.skuService.findByPage(skuVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageSkuRequestVo vo){
		final PageResult<Sku> data = this.skuService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

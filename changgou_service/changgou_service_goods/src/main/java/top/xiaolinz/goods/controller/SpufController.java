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
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.service.SpuService;
import top.xiaolinz.goods_api.vo.PageSpuRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/spu")
@Api(value = "spu接口",tags = {"spu接口" })
public class SpufController {
	@Autowired
	private SpuService spuService;

	/**
	 * 查询所有spu
	 * @return spu集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有spu")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Spu> list = this.spuService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询spu
	 * @spum spuId spuid
	 * @return spu对象
	 */
	@ApiOperation(value = "根据id查询spu")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "spuId",paramType = "path",name = "SpuId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{spuId}")
	public R findById(@PathVariable("spuId") Integer spuId){
		final Spu spu = this.spuService.findSpuById(spuId);

		return R.ok(StatusCode.OK,"查询成功").put("data", spu);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加spu")
	public R addSpu(@RequestBody Spu spu){
		this.spuService.addSpu(spu);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改spu")
	public R updateSpu(@Validated(UpdateGroup.class) @RequestBody Spu spu){
		this.spuService.updateSpu(spu);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{SpuId}")
	@ApiOperation(value = "根据id删除spu")
	@ApiImplicitParams({@ApiImplicitParam(value = "spuid" , paramType = "path",name = "SpuId",required = true,dataTypeClass = Integer.class)})
	public R deleteSpu(@PathVariable("SpuId") Integer spuId){
		this.spuService.deleteSpu(spuId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询spu")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findSpuByConditions(Spu spu){
		final List<Spu> SpuList = this.spuService.findSpuByConditions(spu);

		return R.ok(StatusCode.OK,"查询成功").put("data",SpuList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageSpuRequestVo spuVo){
		final PageResult<Spu> page = this.spuService.findByPage(spuVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageSpuRequestVo vo){
		final PageResult<Spu> data = this.spuService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

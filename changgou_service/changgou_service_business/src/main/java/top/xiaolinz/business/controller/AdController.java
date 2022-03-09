package top.xiaolinz.business.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.business_api.entity.Ad;
import top.xiaolinz.business_api.service.AdService;
import top.xiaolinz.business_api.vo.PageAdRequestVo;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:05
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/ad")
@Api(tags = {"广告接口"},value = "广告接口")
public class AdController {
	@Autowired
	private AdService adService;

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
		final List<Ad> list = this.adService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询数据
	 * @param adId 数据id
	 * @return 数据对象
	 */
	@ApiOperation(value = "根据id查询数据")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "数据id",paramType = "path",name = "AdId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{AdId}")
	public R findById(@PathVariable("AdId") Integer adId){
		final Ad ad = this.adService.findAdById(adId);

		return R.ok(StatusCode.OK,"查询成功").put("data", ad);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加数据")
	public R addAd(@RequestBody Ad ad){
		this.adService.addAd(ad);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改数据")
	public R updateAd(@Validated(UpdateGroup.class) @RequestBody Ad ad){
		this.adService.updateAd(ad);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{AdId}")
	@ApiOperation(value = "根据id删除数据")
	@ApiImplicitParams({@ApiImplicitParam(value = "数据id",paramType = "path",name = "AdId",required = true,dataTypeClass = Integer.class)})
	public R deleteAd(@PathVariable("AdId") Integer adId){
		this.adService.deleteAd(adId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询数据")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findAdByConditions(Ad ad){
		final List<Ad> adList = this.adService.findAdByConditions(ad);

		return R.ok(StatusCode.OK,"查询成功").put("data",adList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageAdRequestVo adVo){
		final PageResult<Ad> page = this.adService.findByPage(adVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageAdRequestVo vo){
		final PageResult<Ad> data = this.adService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

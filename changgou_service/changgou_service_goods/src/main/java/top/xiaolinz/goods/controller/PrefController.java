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
import top.xiaolinz.goods_api.entity.Pref;
import top.xiaolinz.goods_api.service.PrefService;
import top.xiaolinz.goods_api.vo.PagePrefRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/pref")
@Api(value = "优惠接口",tags = {"优惠接口" })
public class PrefController {
	@Autowired
	private PrefService prefService;

	/**
	 * 查询所有优惠
	 * @return 优惠集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有优惠")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Pref> list = this.prefService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询优惠
	 * @prefm prefId 优惠id
	 * @return 优惠对象
	 */
	@ApiOperation(value = "根据id查询优惠")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "优惠id",paramType = "path",name = "PrefId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{PrefId}")
	public R findById(@PathVariable("PrefId") Integer prefId){
		final Pref pref = this.prefService.findPrefById(prefId);

		return R.ok(StatusCode.OK,"查询成功").put("data", pref);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加优惠")
	public R addPref(@RequestBody Pref pref){
		this.prefService.addPref(pref);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改优惠")
	public R updatePref(@Validated(UpdateGroup.class) @RequestBody Pref pref){
		this.prefService.updatePref(pref);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{PrefId}")
	@ApiOperation(value = "根据id删除优惠")
	@ApiImplicitParams({@ApiImplicitParam(value = "优惠id" , paramType = "path",name = "PrefId",required = true,dataTypeClass = Integer.class)})
	public R deletePref(@PathVariable("PrefId") Integer prefId){
		this.prefService.deletePref(prefId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询优惠")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findPrefByConditions(Pref pref){
		final List<Pref> PrefList = this.prefService.findPrefByConditions(pref);

		return R.ok(StatusCode.OK,"查询成功").put("data",PrefList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PagePrefRequestVo prefVo){
		final PageResult<Pref> page = this.prefService.findByPage(prefVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PagePrefRequestVo vo){
		final PageResult<Pref> data = this.prefService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

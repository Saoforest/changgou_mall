package top.xiaolinz.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	 * @param id 品牌id
	 * @return 品牌对象
	 */
	@GetMapping("/{id}")
	public R findById(@PathVariable("id") Integer id){
		final Brand brand = this.brandService.findBrandById(id);

		return R.ok(StatusCode.OK,"查询成功").put("data", brand);
	}
}

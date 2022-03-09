package top.xiaolinz.order.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.order_api.entity.OrderConfig;
import top.xiaolinz.order_api.service.OrderConfigService;
import top.xiaolinz.order_api.vo.PageOrderConfigRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/orderConfig")
@Api(value = "orderConfig接口",tags = {"orderConfig接口" })
public class OrderConfigfController {
	@Autowired
	private OrderConfigService orderConfigService;

	/**
	 * 查询所有orderConfig
	 * @return orderConfig集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有orderConfig")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<OrderConfig> list = this.orderConfigService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询orderConfig
	 * @orderConfigm orderConfigId orderConfigid
	 * @return orderConfig对象
	 */
	@ApiOperation(value = "根据id查询orderConfig")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "orderConfigId",paramType = "path",name = "OrderConfigId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{orderConfigId}")
	public R findById(@PathVariable("orderConfigId") Integer orderConfigId){
		final OrderConfig orderConfig = this.orderConfigService.findOrderConfigById(orderConfigId);

		return R.ok(StatusCode.OK,"查询成功").put("data", orderConfig);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加orderConfig")
	public R addOrderConfig(@RequestBody OrderConfig orderConfig){
		this.orderConfigService.addOrderConfig(orderConfig);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改orderConfig")
	public R updateOrderConfig(@Validated(UpdateGroup.class) @RequestBody OrderConfig orderConfig){
		this.orderConfigService.updateOrderConfig(orderConfig);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{OrderConfigId}")
	@ApiOperation(value = "根据id删除orderConfig")
	@ApiImplicitParams({@ApiImplicitParam(value = "orderConfigid" , paramType = "path",name = "OrderConfigId",required = true,dataTypeClass = Integer.class)})
	public R deleteOrderConfig(@PathVariable("OrderConfigId") Integer orderConfigId){
		this.orderConfigService.deleteOrderConfig(orderConfigId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询orderConfig")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findOrderConfigByConditions(OrderConfig orderConfig){
		final List<OrderConfig> OrderConfigList = this.orderConfigService.findOrderConfigByConditions(orderConfig);

		return R.ok(StatusCode.OK,"查询成功").put("data",OrderConfigList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageOrderConfigRequestVo orderConfigVo){
		final PageResult<OrderConfig> page = this.orderConfigService.findByPage(orderConfigVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageOrderConfigRequestVo vo){
		final PageResult<OrderConfig> data = this.orderConfigService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

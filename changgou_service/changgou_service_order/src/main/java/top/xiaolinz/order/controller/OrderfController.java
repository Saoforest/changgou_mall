package top.xiaolinz.order.controller;

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
import top.xiaolinz.order.utils.TokenDecode;
import top.xiaolinz.order_api.entity.Order;
import top.xiaolinz.order_api.service.OrderService;
import top.xiaolinz.order_api.vo.PageOrderRequestVo;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/order")
@Api(value = "order接口",tags = {"order接口" })
public class OrderfController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private TokenDecode tokenDecode;

	/**
	 * 查询所有order
	 * @return order集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有order")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Order> list = this.orderService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询order
	 * @orderm orderId orderid
	 * @return order对象
	 */
	@ApiOperation(value = "根据id查询order")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "orderId",paramType = "path",name = "OrderId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{orderId}")
	public R findById(@PathVariable("orderId") Integer orderId){
		final Order order = this.orderService.findOrderById(orderId);

		return R.ok(StatusCode.OK,"查询成功").put("data", order);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加order")
	public R addOrder(@RequestBody Order order){
		final String username = this.tokenDecode.getUserInfo().get("username");
		order.setUsername(username);
		this.orderService.addOrder(order);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改order")
	public R updateOrder(@Validated(UpdateGroup.class) @RequestBody Order order){
		this.orderService.updateOrder(order);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{OrderId}")
	@ApiOperation(value = "根据id删除order")
	@ApiImplicitParams({@ApiImplicitParam(value = "orderid" , paramType = "path",name = "OrderId",required = true,dataTypeClass = Integer.class)})
	public R deleteOrder(@PathVariable("OrderId") Integer orderId){
		this.orderService.deleteOrder(orderId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询order")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findOrderByConditions(Order order){
		final List<Order> OrderList = this.orderService.findOrderByConditions(order);

		return R.ok(StatusCode.OK,"查询成功").put("data",OrderList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageOrderRequestVo orderVo){
		final PageResult<Order> page = this.orderService.findByPage(orderVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageOrderRequestVo vo){
		final PageResult<Order> data = this.orderService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

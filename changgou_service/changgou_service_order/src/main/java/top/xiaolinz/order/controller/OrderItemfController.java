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
import top.xiaolinz.order_api.entity.OrderItem;
import top.xiaolinz.order_api.service.OrderItemService;
import top.xiaolinz.order_api.vo.PageOrderItemRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/orderItem")
@Api(value = "orderItem接口",tags = {"orderItem接口" })
public class OrderItemfController {
	@Autowired
	private OrderItemService orderItemService;

	/**
	 * 查询所有orderItem
	 * @return orderItem集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有orderItem")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<OrderItem> list = this.orderItemService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询orderItem
	 * @orderItemm orderItemId orderItemid
	 * @return orderItem对象
	 */
	@ApiOperation(value = "根据id查询orderItem")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "orderItemId",paramType = "path",name = "OrderItemId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{orderItemId}")
	public R findById(@PathVariable("orderItemId") Integer orderItemId){
		final OrderItem orderItem = this.orderItemService.findOrderItemById(orderItemId);

		return R.ok(StatusCode.OK,"查询成功").put("data", orderItem);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加orderItem")
	public R addOrderItem(@RequestBody OrderItem orderItem){
		this.orderItemService.addOrderItem(orderItem);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改orderItem")
	public R updateOrderItem(@Validated(UpdateGroup.class) @RequestBody OrderItem orderItem){
		this.orderItemService.updateOrderItem(orderItem);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{OrderItemId}")
	@ApiOperation(value = "根据id删除orderItem")
	@ApiImplicitParams({@ApiImplicitParam(value = "orderItemid" , paramType = "path",name = "OrderItemId",required = true,dataTypeClass = Integer.class)})
	public R deleteOrderItem(@PathVariable("OrderItemId") Integer orderItemId){
		this.orderItemService.deleteOrderItem(orderItemId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询orderItem")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findOrderItemByConditions(OrderItem orderItem){
		final List<OrderItem> OrderItemList = this.orderItemService.findOrderItemByConditions(orderItem);

		return R.ok(StatusCode.OK,"查询成功").put("data",OrderItemList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageOrderItemRequestVo orderItemVo){
		final PageResult<OrderItem> page = this.orderItemService.findByPage(orderItemVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageOrderItemRequestVo vo){
		final PageResult<OrderItem> data = this.orderItemService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

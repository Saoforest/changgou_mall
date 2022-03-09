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
import top.xiaolinz.order_api.entity.OrderLog;
import top.xiaolinz.order_api.service.OrderLogService;
import top.xiaolinz.order_api.vo.PageOrderLogRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/orderLog")
@Api(value = "orderLog接口",tags = {"orderLog接口" })
public class OrderLogfController {
	@Autowired
	private OrderLogService orderLogService;

	/**
	 * 查询所有orderLog
	 * @return orderLog集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有orderLog")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<OrderLog> list = this.orderLogService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询orderLog
	 * @orderLogm orderLogId orderLogid
	 * @return orderLog对象
	 */
	@ApiOperation(value = "根据id查询orderLog")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "orderLogId",paramType = "path",name = "OrderLogId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{orderLogId}")
	public R findById(@PathVariable("orderLogId") Integer orderLogId){
		final OrderLog orderLog = this.orderLogService.findOrderLogById(orderLogId);

		return R.ok(StatusCode.OK,"查询成功").put("data", orderLog);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加orderLog")
	public R addOrderLog(@RequestBody OrderLog orderLog){
		this.orderLogService.addOrderLog(orderLog);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改orderLog")
	public R updateOrderLog(@Validated(UpdateGroup.class) @RequestBody OrderLog orderLog){
		this.orderLogService.updateOrderLog(orderLog);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{OrderLogId}")
	@ApiOperation(value = "根据id删除orderLog")
	@ApiImplicitParams({@ApiImplicitParam(value = "orderLogid" , paramType = "path",name = "OrderLogId",required = true,dataTypeClass = Integer.class)})
	public R deleteOrderLog(@PathVariable("OrderLogId") Integer orderLogId){
		this.orderLogService.deleteOrderLog(orderLogId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询orderLog")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findOrderLogByConditions(OrderLog orderLog){
		final List<OrderLog> OrderLogList = this.orderLogService.findOrderLogByConditions(orderLog);

		return R.ok(StatusCode.OK,"查询成功").put("data",OrderLogList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageOrderLogRequestVo orderLogVo){
		final PageResult<OrderLog> page = this.orderLogService.findByPage(orderLogVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageOrderLogRequestVo vo){
		final PageResult<OrderLog> data = this.orderLogService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

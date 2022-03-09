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
import top.xiaolinz.order_api.entity.ReturnOrder;
import top.xiaolinz.order_api.service.ReturnOrderService;
import top.xiaolinz.order_api.vo.PageReturnOrderRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/returnOrder")
@Api(value = "returnOrder接口",tags = {"returnOrder接口" })
public class ReturnOrderController {
	@Autowired
	private ReturnOrderService returnOrderService;

	/**
	 * 查询所有returnOrder
	 * @return returnOrder集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有returnOrder")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<ReturnOrder> list = this.returnOrderService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询returnOrder
	 * @returnOrderm returnOrderId returnOrderid
	 * @return returnOrder对象
	 */
	@ApiOperation(value = "根据id查询returnOrder")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "returnOrderId",paramType = "path",name = "ReturnOrderId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{returnOrderId}")
	public R findById(@PathVariable("returnOrderId") Integer returnOrderId){
		final ReturnOrder returnOrder = this.returnOrderService.findReturnOrderById(returnOrderId);

		return R.ok(StatusCode.OK,"查询成功").put("data", returnOrder);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加returnOrder")
	public R addReturnOrder(@RequestBody ReturnOrder returnOrder){
		this.returnOrderService.addReturnOrder(returnOrder);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改returnOrder")
	public R updateReturnOrder(@Validated(UpdateGroup.class) @RequestBody ReturnOrder returnOrder){
		this.returnOrderService.updateReturnOrder(returnOrder);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ReturnOrderId}")
	@ApiOperation(value = "根据id删除returnOrder")
	@ApiImplicitParams({@ApiImplicitParam(value = "returnOrderid" , paramType = "path",name = "ReturnOrderId",required = true,dataTypeClass = Integer.class)})
	public R deleteReturnOrder(@PathVariable("ReturnOrderId") Integer returnOrderId){
		this.returnOrderService.deleteReturnOrder(returnOrderId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询returnOrder")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findReturnOrderByConditions(ReturnOrder returnOrder){
		final List<ReturnOrder> ReturnOrderList = this.returnOrderService.findReturnOrderByConditions(returnOrder);

		return R.ok(StatusCode.OK,"查询成功").put("data",ReturnOrderList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageReturnOrderRequestVo returnOrderVo){
		final PageResult<ReturnOrder> page = this.returnOrderService.findByPage(returnOrderVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageReturnOrderRequestVo vo){
		final PageResult<ReturnOrder> data = this.returnOrderService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

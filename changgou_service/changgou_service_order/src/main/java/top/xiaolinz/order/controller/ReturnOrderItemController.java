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
import top.xiaolinz.order_api.entity.ReturnOrderItem;
import top.xiaolinz.order_api.service.ReturnOrderItemService;
import top.xiaolinz.order_api.vo.PageReturnOrderItemRequestVo;

import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/returnOrderItem")
@Api(value = "returnOrderItem接口",tags = {"returnOrderItem接口" })
public class ReturnOrderItemController {
	@Autowired
	private ReturnOrderItemService returnOrderItemService;

	/**
	 * 查询所有returnOrderItem
	 * @return returnOrderItem集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有returnOrderItem")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<ReturnOrderItem> list = this.returnOrderItemService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询returnOrderItem
	 * @returnOrderItemm returnOrderItemId returnOrderItemid
	 * @return returnOrderItem对象
	 */
	@ApiOperation(value = "根据id查询returnOrderItem")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "returnOrderItemId",paramType = "path",name = "ReturnOrderItemId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{returnOrderItemId}")
	public R findById(@PathVariable("returnOrderItemId") Integer returnOrderItemId){
		final ReturnOrderItem returnOrderItem = this.returnOrderItemService.findReturnOrderItemById(returnOrderItemId);

		return R.ok(StatusCode.OK,"查询成功").put("data", returnOrderItem);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加returnOrderItem")
	public R addReturnOrderItem(@RequestBody ReturnOrderItem returnOrderItem){
		this.returnOrderItemService.addReturnOrderItem(returnOrderItem);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改returnOrderItem")
	public R updateReturnOrderItem(@Validated(UpdateGroup.class) @RequestBody ReturnOrderItem returnOrderItem){
		this.returnOrderItemService.updateReturnOrderItem(returnOrderItem);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{ReturnOrderItemId}")
	@ApiOperation(value = "根据id删除returnOrderItem")
	@ApiImplicitParams({@ApiImplicitParam(value = "returnOrderItemid" , paramType = "path",name = "ReturnOrderItemId",required = true,dataTypeClass = Integer.class)})
	public R deleteReturnOrderItem(@PathVariable("ReturnOrderItemId") Integer returnOrderItemId){
		this.returnOrderItemService.deleteReturnOrderItem(returnOrderItemId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询returnOrderItem")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findReturnOrderItemByConditions(ReturnOrderItem returnOrderItem){
		final List<ReturnOrderItem> ReturnOrderItemList = this.returnOrderItemService.findReturnOrderItemByConditions(returnOrderItem);

		return R.ok(StatusCode.OK,"查询成功").put("data",ReturnOrderItemList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageReturnOrderItemRequestVo returnOrderItemVo){
		final PageResult<ReturnOrderItem> page = this.returnOrderItemService.findByPage(returnOrderItemVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageReturnOrderItemRequestVo vo){
		final PageResult<ReturnOrderItem> data = this.returnOrderItemService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

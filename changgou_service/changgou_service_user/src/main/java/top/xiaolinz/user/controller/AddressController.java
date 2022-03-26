package top.xiaolinz.user.controller;

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
import top.xiaolinz.user_api.entity.Address;
import top.xiaolinz.user_api.service.AddressService;
import top.xiaolinz.user_api.vo.PageAddressRequestVo;


/**
 * @author XiaoLin
 * @date 2022/3/8 16:18
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/address")
@Api(value = "address接口",tags = {"address接口" })
public class AddressController {
	@Autowired
	private AddressService addressService;

	/**
	 * 查询所有address
	 * @return address集合
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有address")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "成功",response = R.class,responseContainer = "Map")
	})
	public R findAll(){
		final List<Address> list = this.addressService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询address
	 * @addressm addressId addressid
	 * @return address对象
	 */
	@ApiOperation(value = "根据id查询address")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "addressId",paramType = "path",name = "AddressId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{addressId}")
	public R findById(@PathVariable("addressId") Integer addressId){
		final Address address = this.addressService.findAddressById(addressId);

		return R.ok(StatusCode.OK,"查询成功").put("data", address);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加address")
	public R addAddress(@RequestBody Address address){
		this.addressService.addAddress(address);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改address")
	public R updateAddress(@Validated(UpdateGroup.class) @RequestBody Address address){
		this.addressService.updateAddress(address);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{AddressId}")
	@ApiOperation(value = "根据id删除address")
	@ApiImplicitParams({@ApiImplicitParam(value = "addressid" , paramType = "path",name = "AddressId",required = true,dataTypeClass = Integer.class)})
	public R deleteAddress(@PathVariable("AddressId") Integer addressId){
		this.addressService.deleteAddress(addressId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询address")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findAddressByConditions(Address address){
		final List<Address> AddressList = this.addressService.findAddressByConditions(address);

		return R.ok(StatusCode.OK,"查询成功").put("data",AddressList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageAddressRequestVo addressVo){
		final PageResult<Address> page = this.addressService.findByPage(addressVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageAddressRequestVo vo){
		final PageResult<Address> data = this.addressService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
	@GetMapping("/user/list")
	public R findAddress(){
		final List<Address> list = this.addressService.findAddressListByUsername();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}
}

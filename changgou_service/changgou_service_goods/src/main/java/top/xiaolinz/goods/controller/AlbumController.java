package top.xiaolinz.goods.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.xiaolinz.common.group.UpdateGroup;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Album;
import top.xiaolinz.goods_api.service.AlbumService;
import top.xiaolinz.goods_api.vo.PageAlbumRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/8 16:05
 * @blog https://www.xiaolinz.top/
 **/
@RestController
@RequestMapping("/album")
@Api(tags = {"相册接口"},value = "相册接口")
public class AlbumController {
	@Autowired
	private AlbumService albumService;

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
		final List<Album> list = this.albumService.findAll();

		return R.ok(StatusCode.OK,"查询成功").put("data",list);
	}

	/**
	 * 根据id查询数据
	 * @param albumId 数据id
	 * @return 数据对象
	 */
	@ApiOperation(value = "根据id查询数据")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "数据id",paramType = "path",name = "AlbumId",required = true,defaultValue = "1115",dataTypeClass = Integer.class)
	})
	@GetMapping("/{AlbumId}")
	public R findById(@PathVariable("AlbumId") Integer albumId){
		final Album album = this.albumService.findAlbumById(albumId);

		return R.ok(StatusCode.OK,"查询成功").put("data", album);
	}

	@PostMapping("/save")
	@ApiOperation(value = "添加数据")
	public R addAlbum(@RequestBody Album album){
		this.albumService.addAlbum(album);
		return R.ok(StatusCode.OK,"添加成功");
	}

	@PutMapping("/update")
	@ApiOperation(value = "修改数据")
	public R updateAlbum(@Validated(UpdateGroup.class) @RequestBody Album album){
		this.albumService.updateAlbum(album);

		return R.ok(StatusCode.OK,"更新成功");
	}

	@DeleteMapping("/delete/{AlbumId}")
	@ApiOperation(value = "根据id删除数据")
	@ApiImplicitParams({@ApiImplicitParam(value = "数据id",paramType = "path",name = "AlbumId",required = true,dataTypeClass = Integer.class)})
	public R deleteAlbum(@PathVariable("AlbumId") Integer albumId){
		this.albumService.deleteAlbum(albumId);

		return R.ok(StatusCode.OK, "删除成功");
	}


	@GetMapping("/info")
	@ApiOperation(value = "多条件查询数据")
	@ApiOperationSupport(ignoreParameters = {"id","image","seq"})
	public R findAlbumByConditions(Album album){
		final List<Album> albumList = this.albumService.findAlbumByConditions(album);

		return R.ok(StatusCode.OK,"查询成功").put("data",albumList);
	}

	@GetMapping("/page")
	@ApiOperation(value = "分页查询")
	public R findByPage(PageAlbumRequestVo albumVo){
		final PageResult<Album> page = this.albumService.findByPage(albumVo);

		return R.ok(StatusCode.OK,"查询成功").put("data",page);
	}

	@GetMapping("/page/info")
	@ApiOperation(value = "条件分页查询")
	public R findByPageAndConditions(PageAlbumRequestVo vo){
		final PageResult<Album> data = this.albumService.findByPageAndCondition(vo);

		return R.ok(StatusCode.OK,"查询成功").put("data",data);
	}
}

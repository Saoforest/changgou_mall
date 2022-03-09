package top.xiaolinz.goods.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods.mapper.AlbumMapper;
import top.xiaolinz.goods_api.entity.Album;
import top.xiaolinz.goods_api.entity.Album;
import top.xiaolinz.goods_api.service.AlbumService;
import top.xiaolinz.goods_api.vo.PageAlbumRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {

	@Override
	public List<Album> findAll() {

		return this.list();
	}

	@Override
	public Album findAlbumById(Integer id) {

		final Album Album = this.getById(id);
		return Album;

	}

	@Override
	public void addAlbum(Album album) {
		this.save(album);
	}

	@Override
	public void updateAlbum(Album album) {
		this.updateById(album);
	}

	@Override
	public void deleteAlbum(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Album> findAlbumByConditions(Album album) {
		if(album == null){
			return new ArrayList<>();
		}

		final Wrapper<Album> wrapper = this.retrievalConditionStructure(album);


		final List<Album> albumList = this.list(wrapper);


		return albumList;
	}

	@Override
	public PageResult<Album> findByPage(PageAlbumRequestVo vo) {

		final HashMap<String, Object> params = new HashMap<>();
		params.put(PageConstant.PAGE,vo.getPage());
		params.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Album> page = this.page(new Query<Album>().getPage(params),new QueryWrapper<Album>());

		return new PageResult<Album>(page);
	}

	@Override
	public PageResult<Album> findByPageAndCondition(PageAlbumRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Album> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Album> page = this.page(new Query<Album>().getPage(map), wrapper);

		return new PageResult<Album>(page);
	}



	/**
	 * 多条件检索构造
	 * @param album 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Album> retrievalConditionStructure(Album album){
		final QueryWrapper<Album> wrapper = new QueryWrapper<>();
		if(StringUtils.isNotEmpty(album.getImage())){
			wrapper.like("image",album.getImage());
		}
		if(StringUtils.isNotEmpty(album.getImageItems())){
			wrapper.like("image_items",album.getImageItems());
		}
		if(album.getId() != null){
			wrapper.eq("id", album.getId());
		}
		if(StringUtils.isNotEmpty(album.getTitle())){
			wrapper.like("title",album.getTitle());
		}

		return wrapper;
	}

	/**
	 * 多条件检索构造
	 * @param album 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Album> retrievalConditionStructure(PageAlbumRequestVo album){
		final QueryWrapper<Album> wrapper = new QueryWrapper<>();
		if(StringUtils.isNotEmpty(album.getImage())){
			wrapper.like("image",album.getImage());
		}
		if(StringUtils.isNotEmpty(album.getImageItems())){
			wrapper.like("image_items",album.getImageItems());
		}
		if(album.getId() != null){
			wrapper.eq("id", album.getId());
		}
		if(StringUtils.isNotEmpty(album.getTitle())){
			wrapper.like("title",album.getTitle());
		}

		return wrapper;
	}

}


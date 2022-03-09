package top.xiaolinz.goods_api.service;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.goods_api.entity.Album;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.goods_api.vo.PageAlbumRequestVo;

import java.util.List;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
public interface AlbumService extends IService<Album> {

	/**
	 * 查询所有品牌
	 *
	 * @return 品牌集合
	 */
	List<Album> findAll();


	/**
	 * 根据id查询对应品牌
	 * @param id 品牌id
	 * @return 品牌对象
	 */
	Album findAlbumById(Integer id);


	/**
	 * 添加数据
	 * @param Album 数据信息
	 */
	void addAlbum(Album Album);

	/**
	 * 修改数据
	 * @param Album 数据对象
	 */
	void updateAlbum(Album Album);


	/**
	 * 删除数据
	 * @param id 数据id
	 */
	void deleteAlbum(Integer id);

	/**
	 * 条件查询数据
	 * @param Album 数据条件信息
	 * @return 查询到的数据集
	 */
	List<Album> findAlbumByConditions(Album Album);


	/**
	 * 分页查询
	 *
	 * @param vo 条件封装
	 * @return 分页数据
	 */
	PageResult<Album> findByPage(PageAlbumRequestVo vo);

	/**
	 * 分页条件查询
	 * @param vo 条件封装
	 * @return 结果集
	 */
	PageResult<Album> findByPageAndCondition(PageAlbumRequestVo vo);


}


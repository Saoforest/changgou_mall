package top.xiaolinz.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.system.mapper.MenuMapper;
import top.xiaolinz.system_api.entity.Menu;
import top.xiaolinz.system_api.entity.Menu;
import top.xiaolinz.system_api.service.MenuService;
import top.xiaolinz.system_api.vo.PageMenuRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{
	@Override
	public List<Menu> findAll() {

		return this.list();
	}

	@Override
	public Menu findMenuById(Integer id) {

		final Menu Menu = this.getById(id);
		return Menu;

	}

	@Override
	public void addMenu(Menu menu) {
		this.save(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		this.updateById(menu);
	}

	@Override
	public void deleteMenu(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Menu> findMenuByConditions(Menu menu) {
		if(menu == null){
			return new ArrayList<>();
		}

		final Wrapper<Menu> wrapper = this.retrievalConditionStructure(menu);


		final List<Menu> menuList = this.list(wrapper);


		return menuList;
	}

	@Override
	public PageResult<Menu> findByPage(PageMenuRequestVo vo) {

		final HashMap<String, Object> menums = new HashMap<>();
		menums.put(PageConstant.PAGE,vo.getPage());
		menums.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Menu> page = this.page(new Query<Menu>().getPage(menums),new QueryWrapper<Menu>());

		return new PageResult<Menu>(page);
	}

	@Override
	public PageResult<Menu> findByPageAndCondition(PageMenuRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Menu> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Menu> page = this.page(new Query<Menu>().getPage(map), wrapper);

		return new PageResult<Menu>(page);
	}



	/**
	 * 多条件检索构造
	 * @param menu 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Menu> retrievalConditionStructure(Menu menu){
		final QueryWrapper<Menu> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(menu.getName())) {
			wrapper.like("name", menu.getName());
		}

		if (StringUtils.isNotBlank(menu.getId())){
			wrapper.like("id", menu.getId());
		}

		if (StringUtils.isNotBlank(menu.getParentId())) {
			wrapper.like("parent_id",menu.getParentId());
		}

		if (StringUtils.isNotBlank(menu.getIcon())) {
			wrapper.like("icon",menu.getIcon());
		}

		if (StringUtils.isNotBlank(menu.getUrl())) {
			wrapper.like("url",menu.getUrl());
		}

		return wrapper;
	}

	public Wrapper<Menu> retrievalConditionStructure(PageMenuRequestVo menu){
		final QueryWrapper<Menu> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(menu.getName())) {
			wrapper.like("name", menu.getName());
        }

		if (StringUtils.isNotBlank(menu.getId())){
			wrapper.like("id", menu.getId());
		}

		if (StringUtils.isNotBlank(menu.getParentId())) {
			wrapper.like("parent_id",menu.getParentId());
        }

		if (StringUtils.isNotBlank(menu.getIcon())) {
			wrapper.like("icon",menu.getIcon());
        }

		if (StringUtils.isNotBlank(menu.getUrl())) {
			wrapper.like("url",menu.getUrl());
        }

		return wrapper;
	}
}

package top.xiaolinz.goods.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods.mapper.CategoryMapper;
import top.xiaolinz.goods_api.entity.Category;
import top.xiaolinz.goods_api.service.CategoryService;
import top.xiaolinz.goods_api.vo.PageCategoryRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
	@Override
	public List<Category> findAll() {

		return this.list();
	}

	@Override
	public Category findCategoryById(Integer id) {

		final Category Category = this.getById(id);
		return Category;

	}

	@Override
	public void addCategory(Category category) {
		this.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		this.updateById(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Category> findCategoryByConditions(Category category) {
		if(category == null){
			return new ArrayList<>();
		}

		final Wrapper<Category> wrapper = this.retrievalConditionStructure(category);


		final List<Category> categoryList = this.list(wrapper);


		return categoryList;
	}

	@Override
	public PageResult<Category> findByPage(PageCategoryRequestVo vo) {

		final HashMap<String, Object> params = new HashMap<>();
		params.put(PageConstant.PAGE,vo.getPage());
		params.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Category> page = this.page(new Query<Category>().getPage(params),new QueryWrapper<Category>());

		return new PageResult<Category>(page);
	}

	@Override
	public PageResult<Category> findByPageAndCondition(PageCategoryRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Category> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Category> page = this.page(new Query<Category>().getPage(map), wrapper);

		return new PageResult<Category>(page);
	}



	/**
	 * 多条件检索构造
	 * @param category 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Category> retrievalConditionStructure(Category category){
		final QueryWrapper<Category> wrapper = new QueryWrapper<>();
		if(StringUtils.isNotBlank(category.getName())){
			wrapper.like("name",category.getName());
		}
		if(StringUtils.isNotBlank(category.getIsShow())){
			wrapper.like("is_show",category.getIsShow());
		}
		if(StringUtils.isNotBlank(category.getIsMenu())){
			wrapper.eq("is_menu",category.getIsMenu());
		}
		if(category.getSeq() != null){
			wrapper.eq("seq",category.getSeq());
		}
		if(category.getId() != null){
			wrapper.eq("id",category.getId());
		}
		if(category.getGoodsNum() != null){
			wrapper.eq("goods_num",category.getGoodsNum());
		}
		if(category.getParentId() != null){
			wrapper.eq("parent_id",category.getParentId());
		}
		if(category.getTemplateId() != null){
			wrapper.eq("template_id",category.getTemplateId());
		}

		return wrapper;
	}

	/**
	 * 多条件检索构造
	 * @param category 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Category> retrievalConditionStructure(PageCategoryRequestVo category){
		final QueryWrapper<Category> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(category.getName())){
			wrapper.like("name",category.getName());
		}
		if(StringUtils.isNotBlank(category.getIsShow())){
			wrapper.like("is_show",category.getIsShow());
		}
		if(StringUtils.isNotBlank(category.getIsMenu())){
			wrapper.eq("is_menu",category.getIsMenu());
		}
		if(category.getSeq() != null){
			wrapper.eq("seq",category.getSeq());
		}
		if(category.getId() != null){
			wrapper.eq("id",category.getId());
		}
		if(category.getGoodsNum() != null){
			wrapper.eq("goods_num",category.getGoodsNum());
		}
		if(category.getParentId() != null){
			wrapper.eq("parent_id",category.getParentId());
		}
		if(category.getTemplateId() != null){
			wrapper.eq("template_id",category.getTemplateId());
		}

		return wrapper;
	}
}


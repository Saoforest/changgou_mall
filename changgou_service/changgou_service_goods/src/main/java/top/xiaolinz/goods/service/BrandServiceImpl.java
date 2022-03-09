package top.xiaolinz.goods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.yaml.snakeyaml.scanner.Constant;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods.mapper.BrandMapper;
import top.xiaolinz.goods_api.entity.Brand;
import top.xiaolinz.goods_api.service.BrandService;
import top.xiaolinz.goods_api.vo.PageBrandRequestVo;


/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

	@Override
	public List<Brand> findAll() {

		return this.list();
	}

	@Override
	public Brand findBrandById(Integer id) {

		final Brand brand = this.getById(id);
		return brand;

	}

	@Override
	public void addBrand(Brand brand) {
		this.save(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		this.updateById(brand);
	}

	@Override
	public void deleteBrand(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Brand> findBrandByConditions(Brand brand) {
		if(brand == null){
			return new ArrayList<>();
		}
		final QueryWrapper<Brand> wrapper = new QueryWrapper<>();
		if(StringUtils.isNotEmpty(brand.getName())){
			wrapper.like("name", brand.getName());
		}

		if(StringUtils.isNotEmpty(brand.getLetter())){
			wrapper.eq("letter",brand.getLetter());
		}

		final List<Brand> brandList = this.list(wrapper);


		return brandList;
	}

	@Override
	public PageResult<Brand> findByPage(PageBrandRequestVo vo) {

		final HashMap<String, Object> params = new HashMap<>();
		params.put(PageConstant.PAGE,vo.getPage());
		params.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Brand> page = this.page(new Query<Brand>().getPage(params),new QueryWrapper<Brand>());

		return new PageResult<Brand>(page);
	}

	@Override
	public PageResult<Brand> findByPageAndCondition(PageBrandRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());
		final QueryWrapper<Brand> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotEmpty(vo.getName())) {
			wrapper.like("name",vo.getName());
        }
		if(StringUtils.isNotEmpty(vo.getLetter())){
			wrapper.eq("letter",vo.getLetter());
		}

		final IPage<Brand> page = this.page(new Query<Brand>().getPage(map), wrapper);

		return new PageResult<Brand>(page);
	}

	@Override
	public List<Brand> findBrandListByCategoryName(String categoryName) {

		final QueryWrapper<Brand> wrapper = new QueryWrapper<Brand>().eq("t3.name", categoryName);
		final List<Brand> brandList = baseMapper.findBrandListByCategoryName(wrapper);

		return brandList;
	}
}


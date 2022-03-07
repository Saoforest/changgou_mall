package top.xiaolinz.goods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.goods.mapper.BrandMapper;
import top.xiaolinz.goods_api.entity.Brand;
import top.xiaolinz.goods_api.service.BrandService;

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
}


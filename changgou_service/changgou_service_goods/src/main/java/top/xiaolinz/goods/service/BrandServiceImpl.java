package top.xiaolinz.goods.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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
}


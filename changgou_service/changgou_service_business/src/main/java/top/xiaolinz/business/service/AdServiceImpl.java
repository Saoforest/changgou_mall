package top.xiaolinz.business.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.business.mapper.AdMapper;
import top.xiaolinz.business_api.entity.Ad;
import top.xiaolinz.business_api.entity.Ad;
import top.xiaolinz.business_api.service.AdService;
import top.xiaolinz.business_api.vo.PageAdRequestVo;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author XiaoLin
 * @date 2022/3/8 23:20
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class AdServiceImpl extends ServiceImpl<AdMapper, Ad> implements AdService {
	@Override
	public List<Ad> findAll() {

		return this.list();
	}

	@Override
	public Ad findAdById(Integer id) {

		final Ad Ad = this.getById(id);
		return Ad;

	}

	@Override
	public void addAd(Ad ad) {
		this.save(ad);
	}

	@Override
	public void updateAd(Ad ad) {
		this.updateById(ad);
	}

	@Override
	public void deleteAd(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Ad> findAdByConditions(Ad ad) {
		if(ad == null){
			return new ArrayList<>();
		}

		final Wrapper<Ad> wrapper = this.retrievalConditionStructure(ad);


		final List<Ad> adList = this.list(wrapper);


		return adList;
	}

	@Override
	public PageResult<Ad> findByPage(PageAdRequestVo vo) {

		final HashMap<String, Object> adms = new HashMap<>();
		adms.put(PageConstant.PAGE,vo.getPage());
		adms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Ad> page = this.page(new Query<Ad>().getPage(adms),new QueryWrapper<Ad>());

		return new PageResult<Ad>(page);
	}

	@Override
	public PageResult<Ad> findByPageAndCondition(PageAdRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Ad> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Ad> page = this.page(new Query<Ad>().getPage(map), wrapper);

		return new PageResult<Ad>(page);
	}



	/**
	 * 多条件检索构造
	 * @param ad 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Ad> retrievalConditionStructure(Ad ad){
		final QueryWrapper<Ad> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(ad.getStatus())){
			wrapper.like("status",ad.getStatus());
		}

		if (StringUtils.isNotBlank(ad.getName())) {
			wrapper.like("name", ad.getName());
        }

		if (StringUtils.isNotBlank(ad.getPosition())){
			wrapper.like("position",ad.getPosition());
		}

		if (StringUtils.isNotBlank(ad.getImage())){
			wrapper.like("image",ad.getImage());
		}

		if (StringUtils.isNotBlank(ad.getUrl())){
			wrapper.like("url",ad.getUrl());
		}

		if (StringUtils.isNotBlank(ad.getRemarks())){
			wrapper.like("remarks",ad.getRemarks());
		}

		if (ad.getId() != null){
			wrapper.eq("id",ad.getId());
		}

		return wrapper;
	}

	public Wrapper<Ad> retrievalConditionStructure(PageAdRequestVo ad){
		final QueryWrapper<Ad> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(ad.getStatus())){
			wrapper.like("status",ad.getStatus());
		}

		if (StringUtils.isNotBlank(ad.getName())) {
			wrapper.like("name", ad.getName());
		}

		if (StringUtils.isNotBlank(ad.getPosition())){
			wrapper.like("position",ad.getPosition());
		}

		if (StringUtils.isNotBlank(ad.getImage())){
			wrapper.like("image",ad.getImage());
		}

		if (StringUtils.isNotBlank(ad.getUrl())){
			wrapper.like("url",ad.getUrl());
		}

		if (StringUtils.isNotBlank(ad.getRemarks())){
			wrapper.like("remarks",ad.getRemarks());
		}

		if (ad.getId() != null){
			wrapper.eq("id",ad.getId());
		}

		return wrapper;
	}
}





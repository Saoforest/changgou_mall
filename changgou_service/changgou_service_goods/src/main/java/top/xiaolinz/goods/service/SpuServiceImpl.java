package top.xiaolinz.goods.service;

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
import top.xiaolinz.goods.mapper.SpuMapper;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.service.SpuService;
import top.xiaolinz.goods_api.vo.PageSkuRequestVo;
import top.xiaolinz.goods_api.vo.PageSpuRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

	@Override
	public List<Spu> findAll() {

		return this.list();
	}

	@Override
	public Spu findSpuById(Integer id) {

		final Spu Spu = this.getById(id);
		return Spu;

	}

	@Override
	public void addSpu(Spu spu) {
		this.save(spu);
	}

	@Override
	public void updateSpu(Spu spu) {
		this.updateById(spu);
	}

	@Override
	public void deleteSpu(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Spu> findSpuByConditions(Spu spu) {
		if(spu == null){
			return new ArrayList<>();
		}

		final Wrapper<Spu> wrapper = this.retrievalConditionStructure(spu);


		final List<Spu> spuList = this.list(wrapper);


		return spuList;
	}

	@Override
	public PageResult<Spu> findByPage(PageSpuRequestVo vo) {

		final HashMap<String, Object> spums = new HashMap<>();
		spums.put(PageConstant.PAGE,vo.getPage());
		spums.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Spu> page = this.page(new Query<Spu>().getPage(spums),new QueryWrapper<Spu>());

		return new PageResult<Spu>(page);
	}

	@Override
	public PageResult<Spu> findByPageAndCondition(PageSpuRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Spu> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Spu> page = this.page(new Query<Spu>().getPage(map), wrapper);

		return new PageResult<Spu>(page);
	}



	/**
	 * 多条件检索构造
	 * @param spu 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Spu> retrievalConditionStructure(Spu spu){
		final QueryWrapper<Spu> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(spu.getId())){
			wrapper.eq("id",spu.getId());
		}

		if(spu.getBrandId() != null){
			wrapper.eq("id",spu.getBrandId());
		}

		if(spu.getCategory1Id() != null){
			wrapper.eq("category1_id",spu.getCategory1Id());
		}

		if(spu.getCategory2Id() != null){
			wrapper.eq("category2_id",spu.getCategory2Id());
		}

		if(spu.getCategory3Id() != null){
			wrapper.eq("category3_id",spu.getCategory3Id());
		}

		if(StringUtils.isNotBlank(spu.getImages())){
			wrapper.like("images",spu.getImages());
		}

		if(StringUtils.isNotBlank(spu.getImage())){
			wrapper.like("image",spu.getImages());
		}

		if(StringUtils.isNotBlank(spu.getName())){
			wrapper.like("name",spu.getName());
		}

		if (StringUtils.isNotBlank(spu.getCaption())) {
			wrapper.like("caption",spu.getCaption());
        }

		if(StringUtils.isNotBlank(spu.getSaleService())){
			wrapper.like("sale_service",spu.getSaleService());
		}

		if (StringUtils.isNotBlank(spu.getIntroduction())){
			wrapper.like("introduction",spu.getIntroduction());
		}

		if (StringUtils.isNotBlank(spu.getIsDelete())){
			wrapper.eq("is_delete",spu.getIsDelete());
		}

		if (StringUtils.isNotBlank(spu.getIsMarketable())){
			wrapper.eq("is_marketable",spu.getIsMarketable());
		}

		if (StringUtils.isNotBlank(spu.getIsEnableSpec())) {
			wrapper.eq("is_enable_spec",spu.getIsEnableSpec());
        }

		if (StringUtils.isNotBlank(spu.getStatus())){
			wrapper.eq("status", spu.getStatus());
		}

		if (spu.getTemplateId() != null){
			wrapper.eq("template_id",spu.getTemplateId());
		}

		if (spu.getFreightId() != null) {
			wrapper.eq("freight_id",spu.getFreightId());
        }

		if(spu.getSaleNum() != null){
			wrapper.eq("sale_num",spu.getSaleNum());
		}

		if (spu.getCommentNum() != null){
			wrapper.eq("comment_num",spu.getCommentNum());
		}

		return wrapper;
	}

	public Wrapper<Spu> retrievalConditionStructure(PageSpuRequestVo spu){
		final QueryWrapper<Spu> wrapper = new QueryWrapper<>();

		if(StringUtils.isNotBlank(spu.getId())){
			wrapper.eq("id",spu.getId());
		}

		if(spu.getBrandId() != null){
			wrapper.eq("id",spu.getBrandId());
		}

		if(spu.getCategory1Id() != null){
			wrapper.eq("category1_id",spu.getCategory1Id());
		}

		if(spu.getCategory2Id() != null){
			wrapper.eq("category2_id",spu.getCategory2Id());
		}

		if(spu.getCategory3Id() != null){
			wrapper.eq("category3_id",spu.getCategory3Id());
		}

		if(StringUtils.isNotBlank(spu.getImages())){
			wrapper.like("images",spu.getImages());
		}

		if(StringUtils.isNotBlank(spu.getImage())){
			wrapper.like("image",spu.getImages());
		}

		if(StringUtils.isNotBlank(spu.getName())){
			wrapper.like("name",spu.getName());
		}

		if (StringUtils.isNotBlank(spu.getCaption())) {
			wrapper.like("caption",spu.getCaption());
		}

		if(StringUtils.isNotBlank(spu.getSaleService())){
			wrapper.like("sale_service",spu.getSaleService());
		}

		if (StringUtils.isNotBlank(spu.getIntroduction())){
			wrapper.like("introduction",spu.getIntroduction());
		}

		if (StringUtils.isNotBlank(spu.getIsDelete())){
			wrapper.eq("is_delete",spu.getIsDelete());
		}

		if (StringUtils.isNotBlank(spu.getIsMarketable())){
			wrapper.eq("is_marketable",spu.getIsMarketable());
		}

		if (StringUtils.isNotBlank(spu.getIsEnableSpec())) {
			wrapper.eq("is_enable_spec",spu.getIsEnableSpec());
		}

		if (StringUtils.isNotBlank(spu.getStatus())){
			wrapper.eq("status", spu.getStatus());
		}

		if (spu.getTemplateId() != null){
			wrapper.eq("template_id",spu.getTemplateId());
		}

		if (spu.getFreightId() != null) {
			wrapper.eq("freight_id",spu.getFreightId());
		}

		if(spu.getSaleNum() != null){
			wrapper.eq("sale_num",spu.getSaleNum());
		}

		if (spu.getCommentNum() != null){
			wrapper.eq("comment_num",spu.getCommentNum());
		}

		return wrapper;
	}

}


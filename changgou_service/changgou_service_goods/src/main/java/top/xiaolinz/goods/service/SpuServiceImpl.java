package top.xiaolinz.goods.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.xiaolinz.common.constant.ExceptionEnum;
import top.xiaolinz.common.utils.IdWorker;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods.exception.Assert;
import top.xiaolinz.goods.mapper.SpuMapper;
import top.xiaolinz.goods_api.entity.*;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.service.*;
import top.xiaolinz.goods_api.vo.Goods;
import top.xiaolinz.goods_api.vo.PageSpuRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

	@Autowired
	private SkuService skuService;

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryBrandService categoryBrandService;

	@Autowired
	private BrandService brandService;

	@Override
	public List<Spu> findAll() {

		return this.list();
	}

	@Override
	public Spu findSpuById(Integer id) {

		final Spu spu = this.getById(id);
		return spu;

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
	public void deleteSpu(String spuId) {
		final Spu spu = this.getById(spuId);
		Assert.notNull(spuId,ExceptionEnum.ERROR_SPU_NULL);
		Assert.isMarketable(spu);

		spu.setStatus("0");

		this.updateById(spu);

		this.removeById(spu);
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

		final HashMap<String, Object> spums = new HashMap<>(10);
		spums.put(PageConstant.PAGE,vo.getPage());
		spums.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Spu> page = this.page(new Query<Spu>().getPage(spums),new QueryWrapper<Spu>());

		return new PageResult<Spu>(page);
	}

	@Override
	public PageResult<Spu> findByPageAndCondition(PageSpuRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>(10);
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Spu> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Spu> page = this.page(new Query<Spu>().getPage(map), wrapper);

		return new PageResult<Spu>(page);
	}

	/**
	 * 新增完整商品单元
	 * @param goods 商品单元封装
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addSpuAndSku(Goods goods) {
		Assert.notNull(goods,ExceptionEnum.ERROR_GOODS_NULL);
		Assert.notNull(goods.getSpu(),ExceptionEnum.ERROR_SPU_NULL);
		Assert.listNotEmpty(goods.getSkuList());


		final Spu spu = goods.getSpu();
		spu.setId(String.valueOf(idWorker.nextId()));
		this.save(spu);
		final long count = this.categoryBrandService.count(new QueryWrapper<CategoryBrand>().eq("category_id", spu.getCategory3Id()).eq("brand_id", spu.getBrandId()));
		if (count > 0) {
			final CategoryBrand brand = new CategoryBrand();
			brand.setCategoryId(spu.getCategory3Id());
			brand.setBrandId(spu.getBrandId());

			this.categoryBrandService.save(brand);
		}
		final Category category = categoryService.getById(spu.getCategory3Id());

		final Brand brand = this.brandService.getById(spu.getBrandId());

		final List<Sku> skuList = goods.getSkuList().stream().map(sku -> {
			sku.setSpuId(spu.getId());
			sku.setId(String.valueOf(idWorker.nextId()));
			if (StringUtils.isEmpty(sku.getSpec())) {
				sku.setSpec("{}");
            }
			final String spec = sku.getSpec();
			String name = spu.getName();
			final HashMap<String, String> map = JSONUtil.toBean(spec, new TypeReference<HashMap<String, String>>() {}, false);
			final StringBuffer buffer = new StringBuffer();
			if (CollUtil.isNotEmpty(map)) {
				for (String value : map.values()) {
					buffer.append(" ").append(value);
				}
            }
			name += buffer.toString();
			sku.setName(name);
			sku.setCreateTime(new Date());
			sku.setUpdateTime(new Date());
			sku.setCategoryId(category.getId());


			sku.setCategoryName(category.getName());

			sku.setBrandName(brand.getName());
			sku.setStatus("2");
			return sku;
		}).collect(Collectors.toList());



			this.skuService.saveBatch(skuList);
	}

	@Override
	public Goods findGoodsBySpuId(String id) {
		final Goods goods = new Goods();

		final Spu spu = this.getById(id);

		goods.setSpu(spu);

		final List<Sku> skuList = this.skuService.list(new QueryWrapper<Sku>().eq("spu_id", spu.getId()));

		goods.setSkuList(skuList);

		return goods;
	}

	@Override
	public void updateGoods(Goods goods) {
		final Spu spu = goods.getSpu();
		if (spu != null) {
			this.updateSpu(spu);
		}

		final List<Sku> list = goods.getSkuList();
		if (CollectionUtils.isNotEmpty(list)){
			this.skuService.updateBatchById(list);
		}


	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void goodsAudit(String spuId) {
		final Spu id = this.getById(spuId);
		Assert.notNull(id,ExceptionEnum.ERROR_SPU_NULL);

		// 审核
		id.setStatus("1");
	//	上架
		id.setIsMarketable("1");

		this.updateSpu(id);
	}

	@Override
	public void goodsPut(String spuId) {
		final Spu spu = this.getById(spuId);
		Assert.notNull(spu, ExceptionEnum.ERROR_SPU_NULL);
		Assert.isVerify(spu);

		spu.setIsMarketable("1");

		this.updateById(spu);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void goodsDown(String spuId) {
		final Spu spu = this.getById(spuId);
		Assert.notNull(spu,ExceptionEnum.ERROR_SPU_NULL);
		spu.setIsMarketable("0");
		this.updateById(spu);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void restore(String spuId) {

		final Spu spu = this.baseMapper.findSpuByIdIgnoreDelete(spuId);
		Assert.notNull(spu, ExceptionEnum.ERROR_SPU_NULL);
		Assert.isDelete(spu);

		spu.setStatus("0");
		spu.setIsDelete("0");

		this.baseMapper.updateSpuByIdRestore(spu);
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


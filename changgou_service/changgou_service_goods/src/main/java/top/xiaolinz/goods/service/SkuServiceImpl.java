package top.xiaolinz.goods.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.goods.mapper.SkuMapper;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.service.SkuService;
import top.xiaolinz.goods_api.vo.PageSkuRequestVo;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

	@Override
	public List<Sku> findAll() {

		return this.list();
	}

	@Override
	public Sku findSkuById(Integer id) {

		final Sku Sku = this.getById(id);
		return Sku;

	}

	@Override
	public void addSku(Sku sku) {
		this.save(sku);
	}

	@Override
	public void updateSku(Sku sku) {
		this.updateById(sku);
	}

	@Override
	public void deleteSku(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Sku> findSkuByConditions(Sku sku) {
		if(sku == null){
			return new ArrayList<>();
		}

		final Wrapper<Sku> wrapper = this.retrievalConditionStructure(sku);


		final List<Sku> skuList = this.list(wrapper);


		return skuList;
	}

	@Override
	public PageResult<Sku> findByPage(PageSkuRequestVo vo) {

		final HashMap<String, Object> skums = new HashMap<>();
		skums.put(PageConstant.PAGE,vo.getPage());
		skums.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Sku> page = this.page(new Query<Sku>().getPage(skums),new QueryWrapper<Sku>());

		return new PageResult<Sku>(page);
	}

	@Override
	public PageResult<Sku> findByPageAndCondition(PageSkuRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Sku> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Sku> page = this.page(new Query<Sku>().getPage(map), wrapper);

		return new PageResult<Sku>(page);
	}

    @Override
    public List<Sku> findSkuListBySpuId(String spuId) {
        final QueryWrapper<Sku> wrapper = new QueryWrapper<>();
        if ("all".equals(spuId)) {
            wrapper.eq("status", "1");
        } else {
            wrapper.eq("spu_id", spuId);
        }
        return this.list(wrapper);
    }


	/**
	 * 多条件检索构造
	 * @param sku 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Sku> retrievalConditionStructure(Sku sku){
		final QueryWrapper<Sku> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(sku.getName())){
			wrapper.like("name",sku.getName());
		}

		if(StringUtils.isNotBlank(sku.getBrandName())){
			wrapper.like("brand_name",sku.getBrandName());
		}

		if(StringUtils.isNotBlank(sku.getCategoryName())){
			wrapper.like("category_name",sku.getCategoryName());
		}

		if(StringUtils.isNotBlank(sku.getImages())){
			wrapper.like("images",sku.getImages());
		}

		if(StringUtils.isNotBlank(sku.getSpec())){
			wrapper.like("spec",sku.getSpec());
		}

		if (StringUtils.isNotBlank(sku.getImage())) {
			wrapper.like("image",sku.getImage());
        }

		if(StringUtils.isNotBlank(sku.getId())){
			wrapper.eq("id",sku.getId());
		}

		if(StringUtils.isNotBlank(sku.getSpuId())){
			wrapper.eq("spu_id",sku.getSpuId());
		}

		if(StringUtils.isNotBlank(sku.getSn())){
			wrapper.eq("sn",sku.getSn());
		}

		if(StringUtils.isNotBlank(sku.getStatus())){
			wrapper.eq("status", sku.getStatus());
		}

		if(sku.getAlertNum() != null){
			wrapper.eq("aliert_num",sku.getAlertNum());
		}

		if(sku.getCategoryId() != null){
			wrapper.eq("category_id",sku.getCategoryId());
		}

		if(sku.getCommentNum() != null){
			wrapper.eq("comment_num",sku.getCommentNum());
		}

		if(sku.getNum() != null){
			wrapper.eq("num",sku.getNum());
		}

		if(sku.getSaleNum() != null){
			wrapper.eq("sale_num",sku.getSaleNum());
		}

		if(sku.getPrice() != null){
			wrapper.eq("price", sku.getPrice());
		}

		if(sku.getWeight() != null){
			wrapper.eq("weight",sku.getWeight());
		}

		return wrapper;
	}

	/**
	 * 多条件检索构造
	 * @param sku 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Sku> retrievalConditionStructure(PageSkuRequestVo sku){
		final QueryWrapper<Sku> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(sku.getName())){
			wrapper.like("name",sku.getName());
		}

		if(StringUtils.isNotBlank(sku.getBrandName())){
			wrapper.like("brand_name",sku.getBrandName());
		}

		if(StringUtils.isNotBlank(sku.getCategoryName())){
			wrapper.like("category_name",sku.getCategoryName());
		}

		if(StringUtils.isNotBlank(sku.getImages())){
			wrapper.like("images",sku.getImages());
		}

		if(StringUtils.isNotBlank(sku.getSpec())){
			wrapper.like("spec",sku.getSpec());
		}

		if (StringUtils.isNotBlank(sku.getImage())) {
			wrapper.like("image",sku.getImage());
		}

		if(StringUtils.isNotBlank(sku.getId())){
			wrapper.eq("id",sku.getId());
		}

		if(StringUtils.isNotBlank(sku.getSpuId())){
			wrapper.eq("spu_id",sku.getSpuId());
		}

		if(StringUtils.isNotBlank(sku.getSn())){
			wrapper.eq("sn",sku.getSn());
		}

		if(StringUtils.isNotBlank(sku.getStatus())){
			wrapper.eq("status", sku.getStatus());
		}

		if(sku.getAlertNum() != null){
			wrapper.eq("aliert_num",sku.getAlertNum());
		}

		if(sku.getCategoryId() != null){
			wrapper.eq("category_id",sku.getCategoryId());
		}

		if(sku.getCommentNum() != null){
			wrapper.eq("comment_num",sku.getCommentNum());
		}

		if(sku.getNum() != null){
			wrapper.eq("num",sku.getNum());
		}

		if(sku.getSaleNum() != null){
			wrapper.eq("sale_num",sku.getSaleNum());
		}

		if(sku.getPrice() != null){
			wrapper.eq("price", sku.getPrice());
		}

		if(sku.getWeight() != null){
			wrapper.eq("weight",sku.getWeight());
		}

		return wrapper;
	}

}


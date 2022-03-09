package top.xiaolinz.order.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.order_api.entity.ReturnOrderItem;
import top.xiaolinz.order.mapper.ReturnOrderItemMapper;
import top.xiaolinz.order_api.service.ReturnOrderItemService;
import top.xiaolinz.order_api.vo.PageReturnOrderItemRequestVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class ReturnOrderItemServiceImpl extends ServiceImpl<ReturnOrderItemMapper, ReturnOrderItem> implements ReturnOrderItemService{
	@Override
	public List<ReturnOrderItem> findAll() {

		return this.list();
	}

	@Override
	public ReturnOrderItem findReturnOrderItemById(Integer id) {

		final ReturnOrderItem ReturnOrderItem = this.getById(id);
		return ReturnOrderItem;

	}

	@Override
	public void addReturnOrderItem(ReturnOrderItem returnOrderItem) {
		this.save(returnOrderItem);
	}

	@Override
	public void updateReturnOrderItem(ReturnOrderItem returnOrderItem) {
		this.updateById(returnOrderItem);
	}

	@Override
	public void deleteReturnOrderItem(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<ReturnOrderItem> findReturnOrderItemByConditions(ReturnOrderItem returnOrderItem) {
		if(returnOrderItem == null){
			return new ArrayList<>();
		}

		final Wrapper<ReturnOrderItem> wrapper = this.retrievalConditionStructure(returnOrderItem);


		final List<ReturnOrderItem> returnOrderItemList = this.list(wrapper);


		return returnOrderItemList;
	}

	@Override
	public PageResult<ReturnOrderItem> findByPage(PageReturnOrderItemRequestVo vo) {

		final HashMap<String, Object> returnOrderItemms = new HashMap<>();
		returnOrderItemms.put(PageConstant.PAGE,vo.getPage());
		returnOrderItemms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<ReturnOrderItem> page = this.page(new Query<ReturnOrderItem>().getPage(returnOrderItemms),new QueryWrapper<ReturnOrderItem>());

		return new PageResult<ReturnOrderItem>(page);
	}

	@Override
	public PageResult<ReturnOrderItem> findByPageAndCondition(PageReturnOrderItemRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<ReturnOrderItem> wrapper = this.retrievalConditionStructure(vo);

		final IPage<ReturnOrderItem> page = this.page(new Query<ReturnOrderItem>().getPage(map), wrapper);

		return new PageResult<ReturnOrderItem>(page);
	}



	/**
	 * 多条件检索构造
	 * @param returnOrderItem 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<ReturnOrderItem> retrievalConditionStructure(ReturnOrderItem returnOrderItem){
		final QueryWrapper<ReturnOrderItem> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(returnOrderItem.getId())){
			wrapper.like("id", returnOrderItem.getId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getSpuId())){
			wrapper.like("spu_id",returnOrderItem.getSpuId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getSkuId())){
			wrapper.like("sku_id",returnOrderItem.getSkuId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getReturnOrderId())){
			wrapper.like("return_order_id",returnOrderItem.getReturnOrderId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getTitle())) {
			wrapper.like("title",returnOrderItem.getTitle());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getImage())){
			wrapper.like("image",returnOrderItem.getImage());
		}

		if (returnOrderItem.getCategoryId() != null){
			wrapper.eq("category_id",returnOrderItem.getCategoryId());
		}

		if (returnOrderItem.getPrice() != null) {
			wrapper.eq("price", returnOrderItem.getPrice());
		}

		if (returnOrderItem.getNum() != null) {
			wrapper.eq("num", returnOrderItem.getNum());
		}

		if (returnOrderItem.getMoney() != null){
			wrapper.eq("money",returnOrderItem.getMoney());
		}

		if (returnOrderItem.getPayMoney() != null){
			wrapper.eq("pay_money",returnOrderItem.getPayMoney());
		}

		if (returnOrderItem.getWeight() != null) {
			wrapper.eq("weight",returnOrderItem.getWeight());
		}





		return wrapper;
	}

	public Wrapper<ReturnOrderItem> retrievalConditionStructure(PageReturnOrderItemRequestVo returnOrderItem){
		final QueryWrapper<ReturnOrderItem> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(returnOrderItem.getId())){
			wrapper.like("id", returnOrderItem.getId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getSpuId())){
			wrapper.like("spu_id",returnOrderItem.getSpuId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getSkuId())){
			wrapper.like("sku_id",returnOrderItem.getSkuId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getReturnOrderId())){
			wrapper.like("return_order_id",returnOrderItem.getReturnOrderId());
		}

		if (StringUtils.isNotBlank(returnOrderItem.getTitle())) {
			wrapper.like("title",returnOrderItem.getTitle());
        }

		if (StringUtils.isNotBlank(returnOrderItem.getImage())){
			wrapper.like("image",returnOrderItem.getImage());
		}

		if (returnOrderItem.getCategoryId() != null){
			wrapper.eq("category_id",returnOrderItem.getCategoryId());
		}

		if (returnOrderItem.getPrice() != null) {
			wrapper.eq("price", returnOrderItem.getPrice());
        }

		if (returnOrderItem.getNum() != null) {
			wrapper.eq("num", returnOrderItem.getNum());
        }

		if (returnOrderItem.getMoney() != null){
			wrapper.eq("money",returnOrderItem.getMoney());
		}

		if (returnOrderItem.getPayMoney() != null){
			wrapper.eq("pay_money",returnOrderItem.getPayMoney());
		}

		if (returnOrderItem.getWeight() != null) {
			wrapper.eq("weight",returnOrderItem.getWeight());
        }

		return wrapper;
	}
}

package top.xiaolinz.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.order.mapper.OrderItemMapper;
import top.xiaolinz.order_api.entity.OrderItem;
import top.xiaolinz.order_api.service.OrderItemService;
import top.xiaolinz.order_api.vo.PageOrderItemRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService{
	@Override
	public List<OrderItem> findAll() {

		return this.list();
	}

	@Override
	public OrderItem findOrderItemById(Integer id) {

		final OrderItem OrderItem = this.getById(id);
		return OrderItem;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addOrderItem(OrderItem orderItem) {
		this.save(orderItem);
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		this.updateById(orderItem);
	}

	@Override
	public void deleteOrderItem(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<OrderItem> findOrderItemByConditions(OrderItem orderItem) {
		if(orderItem == null){
			return new ArrayList<>();
		}

		final Wrapper<OrderItem> wrapper = this.retrievalConditionStructure(orderItem);


		final List<OrderItem> orderItemList = this.list(wrapper);


		return orderItemList;
	}

	@Override
	public PageResult<OrderItem> findByPage(PageOrderItemRequestVo vo) {

		final HashMap<String, Object> orderItemms = new HashMap<>();
		orderItemms.put(PageConstant.PAGE,vo.getPage());
		orderItemms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<OrderItem> page = this.page(new Query<OrderItem>().getPage(orderItemms),new QueryWrapper<OrderItem>());

		return new PageResult<OrderItem>(page);
	}

	@Override
	public PageResult<OrderItem> findByPageAndCondition(PageOrderItemRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<OrderItem> wrapper = this.retrievalConditionStructure(vo);

		final IPage<OrderItem> page = this.page(new Query<OrderItem>().getPage(map), wrapper);

		return new PageResult<OrderItem>(page);
	}



	/**
	 * 多条件检索构造
	 * @param orderItem 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<OrderItem> retrievalConditionStructure(OrderItem orderItem){
		final QueryWrapper<OrderItem> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(orderItem.getId())) {
			wrapper.eq("id", orderItem.getId());
        }

		if (StringUtils.isNotBlank(orderItem.getSpuId())){
			wrapper.eq("spu_id",orderItem.getSpuId());
		}

		if (StringUtils.isNotBlank(orderItem.getSkuId())){
			wrapper.eq("sku_id",orderItem.getSkuId());
		}

		if (StringUtils.isNotBlank(orderItem.getOrderId())){
			wrapper.eq("order_id",orderItem.getOrderId());
		}

		if(StringUtils.isNotBlank(orderItem.getName())){
			wrapper.like("name", orderItem.getName());
		}

		if (StringUtils.isNotBlank(orderItem.getImage())){
			wrapper.like("image",orderItem.getImage());
		}

		if (StringUtils.isNotBlank(orderItem.getIsReturn())){
			wrapper.eq("is_return",orderItem.getIsReturn());
		}

		if (orderItem.getCategoryId1() != null){
			wrapper.eq("category_id1",orderItem.getCategoryId1());
		}

		if (orderItem.getCategoryId2() != null){
			wrapper.eq("category_id2",orderItem.getCategoryId2());
		}

		if (orderItem.getCategoryId3() != null){
			wrapper.eq("category_id3",orderItem.getCategoryId3());
		}

		if (orderItem.getPrice() != null){
			wrapper.eq("price",orderItem.getPrice());
		}

		if (orderItem.getNum() != null){
			wrapper.eq("num", orderItem.getNum());
		}

		if (orderItem.getMoney() != null){
			wrapper.eq("money",orderItem.getMoney());
		}

		if (orderItem.getPayMoney() != null) {
			wrapper.eq("pay_money",orderItem.getPayMoney());
        }

		if (orderItem.getWeight() != null){
			wrapper.eq("weight",orderItem.getWeight());
		}

		if (orderItem.getPostFee() != null){
			wrapper.eq("post_fee",orderItem.getPostFee());
		}




		return wrapper;
	}

	public Wrapper<OrderItem> retrievalConditionStructure(PageOrderItemRequestVo orderItem){
		final QueryWrapper<OrderItem> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(orderItem.getId())) {
			wrapper.eq("id", orderItem.getId());
		}

		if (StringUtils.isNotBlank(orderItem.getSpuId())){
			wrapper.eq("spu_id",orderItem.getSpuId());
		}

		if (StringUtils.isNotBlank(orderItem.getSkuId())){
			wrapper.eq("sku_id",orderItem.getSkuId());
		}

		if (StringUtils.isNotBlank(orderItem.getOrderId())){
			wrapper.eq("order_id",orderItem.getOrderId());
		}

		if(StringUtils.isNotBlank(orderItem.getName())){
			wrapper.like("name", orderItem.getName());
		}

		if (StringUtils.isNotBlank(orderItem.getImage())){
			wrapper.like("image",orderItem.getImage());
		}

		if (StringUtils.isNotBlank(orderItem.getIsReturn())){
			wrapper.eq("is_return",orderItem.getIsReturn());
		}

		if (orderItem.getCategoryId1() != null){
			wrapper.eq("category_id1",orderItem.getCategoryId1());
		}

		if (orderItem.getCategoryId2() != null){
			wrapper.eq("category_id2",orderItem.getCategoryId2());
		}

		if (orderItem.getCategoryId3() != null){
			wrapper.eq("category_id3",orderItem.getCategoryId3());
		}

		if (orderItem.getPrice() != null){
			wrapper.eq("price",orderItem.getPrice());
		}

		if (orderItem.getNum() != null){
			wrapper.eq("num", orderItem.getNum());
		}

		if (orderItem.getMoney() != null){
			wrapper.eq("money",orderItem.getMoney());
		}

		if (orderItem.getPayMoney() != null) {
			wrapper.eq("pay_money",orderItem.getPayMoney());
		}

		if (orderItem.getWeight() != null){
			wrapper.eq("weight",orderItem.getWeight());
		}

		if (orderItem.getPostFee() != null){
			wrapper.eq("post_fee",orderItem.getPostFee());
		}

		return wrapper;
	}
}

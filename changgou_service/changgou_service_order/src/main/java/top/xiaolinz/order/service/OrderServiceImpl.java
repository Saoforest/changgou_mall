package top.xiaolinz.order.service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.xiaolinz.common.utils.RedisUtils;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.order.mapper.OrderMapper;
import top.xiaolinz.order_api.entity.Order;
import top.xiaolinz.order_api.entity.OrderItem;
import top.xiaolinz.order_api.service.CartService;
import top.xiaolinz.order_api.service.OrderItemService;
import top.xiaolinz.order_api.service.OrderService;
import top.xiaolinz.order_api.vo.PageOrderRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{

	public static final String CART = "cart:CART_";
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public List<Order> findAll() {

		return this.list();
	}

	@Override
	public Order findOrderById(Integer id) {

		final Order Order = this.getById(id);
		return Order;

	}

	@Override
	public void addOrder(Order order) {
//		this.save(order);
//		获取商品数据,获取购物车中的数据
		final Map<String, Object> map = this.cartService.getCartList(order.getUsername());
		final List<OrderItem> orderItemList = (List<OrderItem>)map.get("orderItemList");

		//		统计支付总金额,商品总数量
		order.setTotalNum((Integer)map.get("totalNum"));
		order.setTotalMoney((Integer)map.get("totalMoney"));
		order.setPayMoney((Integer)map.get("totalMoney"));

		order.setCreateTime(new Date());
		order.setUpdateTime(new Date());
		order.setBuyerRate("0"); // 0未评价 1已评价
		order.setSourceType("1");

		order.setOrderStatus("0");

		order.setConsignStatus("0");

		order.setPayStatus("0");

		this.save(order);

		final CopyOnWriteArrayList<OrderItem> list = new CopyOnWriteArrayList<>(orderItemList);
		list.parallelStream().forEach(orderItem -> {
			orderItem.setIsReturn("0");
			orderItem.setOrderId(orderItem.getId());
			this.orderItemService.addOrderItem(orderItem);
		});

//		减少库存

//		从redis中删除购物车商品
		this.redisUtils.hdel(CART + order.getUsername());

	}

	@Override
	public void updateOrder(Order order) {
		this.updateById(order);
	}

	@Override
	public void deleteOrder(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Order> findOrderByConditions(Order order) {
		if(order == null){
			return new ArrayList<>();
		}

		final Wrapper<Order> wrapper = this.retrievalConditionStructure(order);


		final List<Order> orderList = this.list(wrapper);


		return orderList;
	}

	@Override
	public PageResult<Order> findByPage(PageOrderRequestVo vo) {

		final HashMap<String, Object> orderms = new HashMap<>();
		orderms.put(PageConstant.PAGE,vo.getPage());
		orderms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Order> page = this.page(new Query<Order>().getPage(orderms),new QueryWrapper<Order>());

		return new PageResult<Order>(page);
	}

	@Override
	public PageResult<Order> findByPageAndCondition(PageOrderRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Order> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Order> page = this.page(new Query<Order>().getPage(map), wrapper);

		return new PageResult<Order>(page);
	}



	/**
	 * 多条件检索构造
	 * @param order 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Order> retrievalConditionStructure(Order order){
		final QueryWrapper<Order> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(order.getId())) {
			wrapper.eq("id", order.getId());
        }

		if (StringUtils.isNotBlank(order.getPayType())){
			wrapper.eq("pay_type",order.getPayType());
		}

		if (StringUtils.isNotBlank(order.getShippingName())){
			wrapper.like("shipping_name",order.getShippingName());
		}

		if (StringUtils.isNotBlank(order.getShippingCode())){
			wrapper.like("shipping_code",order.getShippingCode());
		}

		if (StringUtils.isNotBlank(order.getUsername())){
			wrapper.like("username",order.getUsername());
		}

		if (StringUtils.isNotBlank(order.getBuyerMessage())){
			wrapper.like("buyer_message",order.getBuyerMessage());
		}

		if (StringUtils.isNotBlank(order.getBuyerRate())) {
			wrapper.like("buyer_rate",order.getBuyerRate());
        }

		if (StringUtils.isNotBlank(order.getReceiverContact())) {
			wrapper.like("receiver_contact",order.getReceiverContact());
        }

		if (StringUtils.isNotBlank(order.getReceiverMobile())){
			wrapper.like("receiver_mobile",order.getReceiverMobile());
		}

		if (StringUtils.isNotBlank(order.getReceiverAddress())) {
			wrapper.like("receiver_address",order.getReceiverAddress());
        }

		if (StringUtils.isNotBlank(order.getSourceType())) {
			wrapper.eq("source_type",order.getSourceType());
        }

		if (StringUtils.isNotBlank(order.getTransactionId())){
			wrapper.like("transaction_id",order.getTransactionId());
		}

		if (StringUtils.isNotBlank(order.getOrderStatus())){
			wrapper.eq("order_status",order.getOrderStatus());
		}

		if (StringUtils.isNotBlank(order.getPayStatus())){
			wrapper.eq("pay_status",order.getPayStatus());
		}

		if (StringUtils.isNotBlank(order.getConsignStatus())){
			wrapper.eq("consign_status",order.getConsignStatus());
		}

		if (StringUtils.isNotBlank(order.getIsDelete())){
			wrapper.eq("is_delete",order.getIsDelete());
		}
		if (order.getTotalNum() != null){
			wrapper.eq("total_num",order.getTotalNum());
		}

		if (order.getTotalMoney() != null){
			wrapper.eq("total_money",order.getTotalMoney());
		}

		if (order.getPreMoney() != null){
			wrapper.eq("pre_money",order.getPreMoney());
		}

		if (order.getPostFee() != null){
			wrapper.eq("post_fee",order.getPostFee());
		}

		if (order.getPayMoney() != null){
			wrapper.eq("pay_money",order.getPayMoney());
		}





		return wrapper;
	}

	public Wrapper<Order> retrievalConditionStructure(PageOrderRequestVo order){
		final QueryWrapper<Order> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(order.getId())) {
			wrapper.eq("id", order.getId());
		}

		if (StringUtils.isNotBlank(order.getPayType())){
			wrapper.eq("pay_type",order.getPayType());
		}

		if (StringUtils.isNotBlank(order.getShippingName())){
			wrapper.like("shipping_name",order.getShippingName());
		}

		if (StringUtils.isNotBlank(order.getShippingCode())){
			wrapper.like("shipping_code",order.getShippingCode());
		}

		if (StringUtils.isNotBlank(order.getUsername())){
			wrapper.like("username",order.getUsername());
		}

		if (StringUtils.isNotBlank(order.getBuyerMessage())){
			wrapper.like("buyer_message",order.getBuyerMessage());
		}

		if (StringUtils.isNotBlank(order.getBuyerRate())) {
			wrapper.like("buyer_rate",order.getBuyerRate());
		}

		if (StringUtils.isNotBlank(order.getReceiverContact())) {
			wrapper.like("receiver_contact",order.getReceiverContact());
		}

		if (StringUtils.isNotBlank(order.getReceiverMobile())){
			wrapper.like("receiver_mobile",order.getReceiverMobile());
		}

		if (StringUtils.isNotBlank(order.getReceiverAddress())) {
			wrapper.like("receiver_address",order.getReceiverAddress());
		}

		if (StringUtils.isNotBlank(order.getSourceType())) {
			wrapper.eq("source_type",order.getSourceType());
		}

		if (StringUtils.isNotBlank(order.getTransactionId())){
			wrapper.like("transaction_id",order.getTransactionId());
		}

		if (StringUtils.isNotBlank(order.getOrderStatus())){
			wrapper.eq("order_status",order.getOrderStatus());
		}

		if (StringUtils.isNotBlank(order.getPayStatus())){
			wrapper.eq("pay_status",order.getPayStatus());
		}

		if (StringUtils.isNotBlank(order.getConsignStatus())){
			wrapper.eq("consign_status",order.getConsignStatus());
		}

		if (StringUtils.isNotBlank(order.getIsDelete())){
			wrapper.eq("is_delete",order.getIsDelete());
		}
		if (order.getTotalNum() != null){
			wrapper.eq("total_num",order.getTotalNum());
		}

		if (order.getTotalMoney() != null){
			wrapper.eq("total_money",order.getTotalMoney());
		}

		if (order.getPreMoney() != null){
			wrapper.eq("pre_money",order.getPreMoney());
		}

		if (order.getPostFee() != null){
			wrapper.eq("post_fee",order.getPostFee());
		}

		if (order.getPayMoney() != null){
			wrapper.eq("pay_money",order.getPayMoney());
		}

		return wrapper;
	}
}

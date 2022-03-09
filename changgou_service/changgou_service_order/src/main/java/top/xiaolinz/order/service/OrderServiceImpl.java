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
import top.xiaolinz.order.mapper.OrderMapper;
import top.xiaolinz.order_api.entity.Order;
import top.xiaolinz.order_api.entity.Order;
import top.xiaolinz.order_api.service.OrderService;
import top.xiaolinz.order_api.vo.PageOrderRequestVo;

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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{
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
		this.save(order);
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

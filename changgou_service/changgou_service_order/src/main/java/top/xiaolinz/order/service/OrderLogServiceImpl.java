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
import top.xiaolinz.order.mapper.OrderLogMapper;
import top.xiaolinz.order_api.entity.OrderLog;
import top.xiaolinz.order_api.service.OrderLogService;
import top.xiaolinz.order_api.vo.PageOrderLogRequestVo;

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
public class OrderLogServiceImpl extends ServiceImpl<OrderLogMapper, OrderLog> implements OrderLogService{
	@Override
	public List<OrderLog> findAll() {

		return this.list();
	}

	@Override
	public OrderLog findOrderLogById(Integer id) {

		final OrderLog OrderLog = this.getById(id);
		return OrderLog;

	}

	@Override
	public void addOrderLog(OrderLog orderLog) {
		this.save(orderLog);
	}

	@Override
	public void updateOrderLog(OrderLog orderLog) {
		this.updateById(orderLog);
	}

	@Override
	public void deleteOrderLog(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<OrderLog> findOrderLogByConditions(OrderLog orderLog) {
		if(orderLog == null){
			return new ArrayList<>();
		}

		final Wrapper<OrderLog> wrapper = this.retrievalConditionStructure(orderLog);


		final List<OrderLog> orderLogList = this.list(wrapper);


		return orderLogList;
	}

	@Override
	public PageResult<OrderLog> findByPage(PageOrderLogRequestVo vo) {

		final HashMap<String, Object> orderLogms = new HashMap<>();
		orderLogms.put(PageConstant.PAGE,vo.getPage());
		orderLogms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<OrderLog> page = this.page(new Query<OrderLog>().getPage(orderLogms),new QueryWrapper<OrderLog>());

		return new PageResult<OrderLog>(page);
	}

	@Override
	public PageResult<OrderLog> findByPageAndCondition(PageOrderLogRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<OrderLog> wrapper = this.retrievalConditionStructure(vo);

		final IPage<OrderLog> page = this.page(new Query<OrderLog>().getPage(map), wrapper);

		return new PageResult<OrderLog>(page);
	}



	/**
	 * 多条件检索构造
	 * @param orderLog 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<OrderLog> retrievalConditionStructure(OrderLog orderLog){
		final QueryWrapper<OrderLog> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(orderLog.getId())) {
			wrapper.like("id",orderLog.getId());
        }

		if (StringUtils.isNotBlank(orderLog.getOperater())){
			wrapper.like("operater",orderLog.getOperater());
		}

		if (orderLog.getOrderId() != null){
			wrapper.like("order_id",orderLog.getOrderId());
		}

		if (StringUtils.isNotBlank(orderLog.getOrderStatus())){
			wrapper.like("order_status",orderLog.getOrderStatus());
		}

		if (StringUtils.isNotBlank(orderLog.getPayStatus())){
			wrapper.like("pay_status",orderLog.getPayStatus());
		}

		if (StringUtils.isNotBlank(orderLog.getConsignStatus())) {
			wrapper.like("consign_status",orderLog.getConsignStatus());
        }

		if (StringUtils.isNotBlank(orderLog.getRemarks())) {
			wrapper.like("remarks",orderLog.getRemarks());
        }






		return wrapper;
	}

	public Wrapper<OrderLog> retrievalConditionStructure(PageOrderLogRequestVo orderLog){
		final QueryWrapper<OrderLog> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(orderLog.getId())) {
			wrapper.like("id",orderLog.getId());
		}

		if (StringUtils.isNotBlank(orderLog.getOperater())){
			wrapper.like("operater",orderLog.getOperater());
		}

		if (orderLog.getOrderId() != null){
			wrapper.like("order_id",orderLog.getOrderId());
		}

		if (StringUtils.isNotBlank(orderLog.getOrderStatus())){
			wrapper.like("order_status",orderLog.getOrderStatus());
		}

		if (StringUtils.isNotBlank(orderLog.getPayStatus())){
			wrapper.like("pay_status",orderLog.getPayStatus());
		}

		if (StringUtils.isNotBlank(orderLog.getConsignStatus())) {
			wrapper.like("consign_status",orderLog.getConsignStatus());
		}

		if (StringUtils.isNotBlank(orderLog.getRemarks())) {
			wrapper.like("remarks",orderLog.getRemarks());
		}

		return wrapper;
	}
}

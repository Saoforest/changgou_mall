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
import top.xiaolinz.order.mapper.OrderConfigMapper;
import top.xiaolinz.order_api.entity.OrderConfig;
import top.xiaolinz.order_api.service.OrderConfigService;
import top.xiaolinz.order_api.vo.PageOrderConfigRequestVo;

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
public class OrderConfigServiceImpl extends ServiceImpl<OrderConfigMapper, OrderConfig> implements OrderConfigService{
	@Override
	public List<OrderConfig> findAll() {

		return this.list();
	}

	@Override
	public OrderConfig findOrderConfigById(Integer id) {

		final OrderConfig OrderConfig = this.getById(id);
		return OrderConfig;

	}

	@Override
	public void addOrderConfig(OrderConfig orderConfig) {
		this.save(orderConfig);
	}

	@Override
	public void updateOrderConfig(OrderConfig orderConfig) {
		this.updateById(orderConfig);
	}

	@Override
	public void deleteOrderConfig(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<OrderConfig> findOrderConfigByConditions(OrderConfig orderConfig) {
		if(orderConfig == null){
			return new ArrayList<>();
		}

		final Wrapper<OrderConfig> wrapper = this.retrievalConditionStructure(orderConfig);


		final List<OrderConfig> orderConfigList = this.list(wrapper);


		return orderConfigList;
	}

	@Override
	public PageResult<OrderConfig> findByPage(PageOrderConfigRequestVo vo) {

		final HashMap<String, Object> orderConfigms = new HashMap<>();
		orderConfigms.put(PageConstant.PAGE,vo.getPage());
		orderConfigms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<OrderConfig> page = this.page(new Query<OrderConfig>().getPage(orderConfigms),new QueryWrapper<OrderConfig>());

		return new PageResult<OrderConfig>(page);
	}

	@Override
	public PageResult<OrderConfig> findByPageAndCondition(PageOrderConfigRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<OrderConfig> wrapper = this.retrievalConditionStructure(vo);

		final IPage<OrderConfig> page = this.page(new Query<OrderConfig>().getPage(map), wrapper);

		return new PageResult<OrderConfig>(page);
	}



	/**
	 * 多条件检索构造
	 * @param orderConfig 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<OrderConfig> retrievalConditionStructure(OrderConfig orderConfig){
		final QueryWrapper<OrderConfig> wrapper = new QueryWrapper<>();

		if (orderConfig.getId() != null) {
			wrapper.eq("id", orderConfig.getId());
		}

		if (orderConfig.getOrderTimeout() != null){
			wrapper.eq("order_timeout",orderConfig.getOrderTimeout());
		}

		if (orderConfig.getServiceTimeout() != null){
			wrapper.eq("service_timeout",orderConfig.getServiceTimeout());
		}

		if (orderConfig.getTakeTimeout() != null){
			wrapper.eq("take_timeout",orderConfig.getTakeTimeout());
		}

		if (orderConfig.getSeckillTimeout() != null){
			wrapper.eq("seckill_timeout",orderConfig.getSeckillTimeout());
		}

		if (orderConfig.getCommentTimeout() != null){
			wrapper.eq("comment_timeout",orderConfig.getCommentTimeout());
		}


		return wrapper;
	}

	public Wrapper<OrderConfig> retrievalConditionStructure(PageOrderConfigRequestVo orderConfig){
		final QueryWrapper<OrderConfig> wrapper = new QueryWrapper<>();

		if (orderConfig.getId() != null) {
			wrapper.eq("id", orderConfig.getId());
		}

		if (orderConfig.getOrderTimeout() != null){
			wrapper.eq("order_timeout",orderConfig.getOrderTimeout());
		}

		if (orderConfig.getServiceTimeout() != null){
			wrapper.eq("service_timeout",orderConfig.getServiceTimeout());
		}

		if (orderConfig.getTakeTimeout() != null){
			wrapper.eq("take_timeout",orderConfig.getTakeTimeout());
		}

		if (orderConfig.getSeckillTimeout() != null){
			wrapper.eq("seckill_timeout",orderConfig.getSeckillTimeout());
		}

		if (orderConfig.getCommentTimeout() != null){
			wrapper.eq("comment_timeout",orderConfig.getCommentTimeout());
		}

		return wrapper;
	}
}

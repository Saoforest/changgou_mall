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
import top.xiaolinz.order_api.entity.ReturnOrder;
import top.xiaolinz.order.mapper.ReturnOrderMapper;
import top.xiaolinz.order_api.service.ReturnOrderService;
import top.xiaolinz.order_api.vo.PageReturnOrderRequestVo;

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
public class ReturnOrderServiceImpl extends ServiceImpl<ReturnOrderMapper, ReturnOrder> implements ReturnOrderService{
	@Override
	public List<ReturnOrder> findAll() {

		return this.list();
	}

	@Override
	public ReturnOrder findReturnOrderById(Integer id) {

		final ReturnOrder ReturnOrder = this.getById(id);
		return ReturnOrder;

	}

	@Override
	public void addReturnOrder(ReturnOrder returnOrder) {
		this.save(returnOrder);
	}

	@Override
	public void updateReturnOrder(ReturnOrder returnOrder) {
		this.updateById(returnOrder);
	}

	@Override
	public void deleteReturnOrder(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<ReturnOrder> findReturnOrderByConditions(ReturnOrder returnOrder) {
		if(returnOrder == null){
			return new ArrayList<>();
		}

		final Wrapper<ReturnOrder> wrapper = this.retrievalConditionStructure(returnOrder);


		final List<ReturnOrder> returnOrderList = this.list(wrapper);


		return returnOrderList;
	}

	@Override
	public PageResult<ReturnOrder> findByPage(PageReturnOrderRequestVo vo) {

		final HashMap<String, Object> returnOrderms = new HashMap<>();
		returnOrderms.put(PageConstant.PAGE,vo.getPage());
		returnOrderms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<ReturnOrder> page = this.page(new Query<ReturnOrder>().getPage(returnOrderms),new QueryWrapper<ReturnOrder>());

		return new PageResult<ReturnOrder>(page);
	}

	@Override
	public PageResult<ReturnOrder> findByPageAndCondition(PageReturnOrderRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<ReturnOrder> wrapper = this.retrievalConditionStructure(vo);

		final IPage<ReturnOrder> page = this.page(new Query<ReturnOrder>().getPage(map), wrapper);

		return new PageResult<ReturnOrder>(page);
	}



	/**
	 * 多条件检索构造
	 * @param returnOrder 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<ReturnOrder> retrievalConditionStructure(ReturnOrder returnOrder){
		final QueryWrapper<ReturnOrder> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(returnOrder.getId())) {
			wrapper.like("id", returnOrder.getId());
		}

		if (returnOrder.getOrderId() != null){
			wrapper.like("order_id",returnOrder.getOrderId());
		}

		if (StringUtils.isNotBlank(returnOrder.getUserAccount())) {
			wrapper.like("user_account",returnOrder.getUserAccount());
		}

		if (StringUtils.isNotBlank(returnOrder.getLinkman())) {
			wrapper.like("linkman",returnOrder.getLinkman());
		}

		if (StringUtils.isNotBlank(returnOrder.getLinkmanMobile())) {
			wrapper.like("linkman_mobile",returnOrder.getLinkmanMobile());
		}

		if (StringUtils.isNotBlank(returnOrder.getType())){
			wrapper.like("type",returnOrder.getType());
		}

		if (StringUtils.isNotBlank(returnOrder.getStatus())) {
			wrapper.like("status",returnOrder.getStatus());
		}

		if (StringUtils.isNotBlank(returnOrder.getEvidence())){
			wrapper.like("evidence",returnOrder.getEvidence());
		}

		if (StringUtils.isNotBlank(returnOrder.getDescription())) {
			wrapper.like("description",returnOrder.getDescription());
		}

		if (StringUtils.isNotBlank(returnOrder.getRemark())) {
			wrapper.like("remark",returnOrder.getRemark());
		}

		if (returnOrder.getReturnMoney() != null) {
			wrapper.eq("return_money",returnOrder.getReturnMoney());
		}

		if (returnOrder.getReturnCause() != null) {
			wrapper.eq("return_cause",returnOrder.getReturnCause());
		}

		if (returnOrder.getAdminId() != null) {
			wrapper.eq("admin_id",returnOrder.getAdminId());
		}





		return wrapper;
	}

	public Wrapper<ReturnOrder> retrievalConditionStructure(PageReturnOrderRequestVo returnOrder){
		final QueryWrapper<ReturnOrder> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(returnOrder.getId())) {
			wrapper.like("id", returnOrder.getId());
        }

		if (returnOrder.getOrderId() != null){
			wrapper.like("order_id",returnOrder.getOrderId());
		}

		if (StringUtils.isNotBlank(returnOrder.getUserAccount())) {
			wrapper.like("user_account",returnOrder.getUserAccount());
        }

		if (StringUtils.isNotBlank(returnOrder.getLinkman())) {
			wrapper.like("linkman",returnOrder.getLinkman());
        }

		if (StringUtils.isNotBlank(returnOrder.getLinkmanMobile())) {
			wrapper.like("linkman_mobile",returnOrder.getLinkmanMobile());
        }

		if (StringUtils.isNotBlank(returnOrder.getType())){
			wrapper.like("type",returnOrder.getType());
		}

		if (StringUtils.isNotBlank(returnOrder.getStatus())) {
			wrapper.like("status",returnOrder.getStatus());
        }

		if (StringUtils.isNotBlank(returnOrder.getEvidence())){
			wrapper.like("evidence",returnOrder.getEvidence());
		}

		if (StringUtils.isNotBlank(returnOrder.getDescription())) {
			wrapper.like("description",returnOrder.getDescription());
        }

		if (StringUtils.isNotBlank(returnOrder.getRemark())) {
			wrapper.like("remark",returnOrder.getRemark());
        }

		if (returnOrder.getReturnMoney() != null) {
			wrapper.eq("return_money",returnOrder.getReturnMoney());
        }

		if (returnOrder.getReturnCause() != null) {
			wrapper.eq("return_cause",returnOrder.getReturnCause());
        }

		if (returnOrder.getAdminId() != null) {
			wrapper.eq("admin_id",returnOrder.getAdminId());
        }

		return wrapper;
	}
}


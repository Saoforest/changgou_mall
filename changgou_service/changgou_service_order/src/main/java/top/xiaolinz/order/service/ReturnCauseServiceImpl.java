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
import top.xiaolinz.order.mapper.ReturnCauseMapper;
import top.xiaolinz.order_api.entity.ReturnCause;
import top.xiaolinz.order_api.service.ReturnCauseService;
import top.xiaolinz.order_api.vo.PageReturnCauseRequestVo;

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
public class ReturnCauseServiceImpl extends ServiceImpl<ReturnCauseMapper, ReturnCause> implements ReturnCauseService{
	@Override
	public List<ReturnCause> findAll() {

		return this.list();
	}

	@Override
	public ReturnCause findReturnCauseById(Integer id) {

		final ReturnCause ReturnCause = this.getById(id);
		return ReturnCause;

	}

	@Override
	public void addReturnCause(ReturnCause returnCause) {
		this.save(returnCause);
	}

	@Override
	public void updateReturnCause(ReturnCause returnCause) {
		this.updateById(returnCause);
	}

	@Override
	public void deleteReturnCause(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<ReturnCause> findReturnCauseByConditions(ReturnCause returnCause) {
		if(returnCause == null){
			return new ArrayList<>();
		}

		final Wrapper<ReturnCause> wrapper = this.retrievalConditionStructure(returnCause);


		final List<ReturnCause> returnCauseList = this.list(wrapper);


		return returnCauseList;
	}

	@Override
	public PageResult<ReturnCause> findByPage(PageReturnCauseRequestVo vo) {

		final HashMap<String, Object> returnCausems = new HashMap<>();
		returnCausems.put(PageConstant.PAGE,vo.getPage());
		returnCausems.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<ReturnCause> page = this.page(new Query<ReturnCause>().getPage(returnCausems),new QueryWrapper<ReturnCause>());

		return new PageResult<ReturnCause>(page);
	}

	@Override
	public PageResult<ReturnCause> findByPageAndCondition(PageReturnCauseRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<ReturnCause> wrapper = this.retrievalConditionStructure(vo);

		final IPage<ReturnCause> page = this.page(new Query<ReturnCause>().getPage(map), wrapper);

		return new PageResult<ReturnCause>(page);
	}



	/**
	 * 多条件检索构造
	 * @param returnCause 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<ReturnCause> retrievalConditionStructure(ReturnCause returnCause){
		final QueryWrapper<ReturnCause> wrapper = new QueryWrapper<>();

		if (returnCause.getCause() != null){
			wrapper.like("cause",returnCause.getCause());
		}

		if (StringUtils.isNotBlank(returnCause.getStatus())){
			wrapper.like("status",returnCause.getStatus());
		}

		if (returnCause.getId() != null){
			wrapper.eq("id", returnCause.getId());
		}

		if (returnCause.getSeq() != null){
			wrapper.eq("seq",returnCause.getSeq());
		}





		return wrapper;
	}

	public Wrapper<ReturnCause> retrievalConditionStructure(PageReturnCauseRequestVo returnCause){
		final QueryWrapper<ReturnCause> wrapper = new QueryWrapper<>();

		if (returnCause.getCause() != null){
			wrapper.like("cause",returnCause.getCause());
		}

		if (StringUtils.isNotBlank(returnCause.getStatus())){
			wrapper.like("status",returnCause.getStatus());
		}

		if (returnCause.getId() != null){
			wrapper.eq("id", returnCause.getId());
		}

		if (returnCause.getSeq() != null){
			wrapper.eq("seq",returnCause.getSeq());
		}

		return wrapper;
	}
}

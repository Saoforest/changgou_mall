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
import top.xiaolinz.order.mapper.UndoLogMapper;
import top.xiaolinz.order_api.entity.UndoLog;
import top.xiaolinz.order_api.service.UndoLogService;
import top.xiaolinz.order_api.vo.PageUndoLogRequestVo;

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
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLog> implements UndoLogService{
	@Override
	public List<UndoLog> findAll() {

		return this.list();
	}

	@Override
	public UndoLog findUndoLogById(Integer id) {

		final UndoLog UndoLog = this.getById(id);
		return UndoLog;

	}

	@Override
	public void addUndoLog(UndoLog undoLog) {
		this.save(undoLog);
	}

	@Override
	public void updateUndoLog(UndoLog undoLog) {
		this.updateById(undoLog);
	}

	@Override
	public void deleteUndoLog(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<UndoLog> findUndoLogByConditions(UndoLog undoLog) {
		if(undoLog == null){
			return new ArrayList<>();
		}

		final Wrapper<UndoLog> wrapper = this.retrievalConditionStructure(undoLog);


		final List<UndoLog> undoLogList = this.list(wrapper);


		return undoLogList;
	}

	@Override
	public PageResult<UndoLog> findByPage(PageUndoLogRequestVo vo) {

		final HashMap<String, Object> undoLogms = new HashMap<>();
		undoLogms.put(PageConstant.PAGE,vo.getPage());
		undoLogms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<UndoLog> page = this.page(new Query<UndoLog>().getPage(undoLogms),new QueryWrapper<UndoLog>());

		return new PageResult<UndoLog>(page);
	}

	@Override
	public PageResult<UndoLog> findByPageAndCondition(PageUndoLogRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<UndoLog> wrapper = this.retrievalConditionStructure(vo);

		final IPage<UndoLog> page = this.page(new Query<UndoLog>().getPage(map), wrapper);

		return new PageResult<UndoLog>(page);
	}



	/**
	 * 多条件检索构造
	 * @param undoLog 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<UndoLog> retrievalConditionStructure(UndoLog undoLog){
		final QueryWrapper<UndoLog> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(undoLog.getXid())) {
			wrapper.like("xid",undoLog.getXid());
        }

		if (StringUtils.isNotBlank(undoLog.getExt())){
			wrapper.like("ext",undoLog.getExt());
		}

		if (undoLog.getLogStatus() != null){
			wrapper.eq("log_status",undoLog.getLogStatus());
		}

		return wrapper;
	}

	public Wrapper<UndoLog> retrievalConditionStructure(PageUndoLogRequestVo undoLog){
		final QueryWrapper<UndoLog> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(undoLog.getXid())) {
			wrapper.like("xid",undoLog.getXid());
		}

		if (StringUtils.isNotBlank(undoLog.getExt())){
			wrapper.like("ext",undoLog.getExt());
		}

		if (undoLog.getLogStatus() != null){
			wrapper.eq("log_status",undoLog.getLogStatus());
		}

		return wrapper;
	}
}

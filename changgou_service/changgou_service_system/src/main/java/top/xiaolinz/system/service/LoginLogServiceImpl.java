package top.xiaolinz.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.system_api.entity.LoginLog;
import top.xiaolinz.system_api.entity.LoginLog;
import top.xiaolinz.system.mapper.LoginLogMapper;
import top.xiaolinz.system_api.service.LoginLogService;
import top.xiaolinz.system_api.vo.PageLoginLogRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService{
	@Override
	public List<LoginLog> findAll() {

		return this.list();
	}

	@Override
	public LoginLog findLoginLogById(Integer id) {

		final LoginLog LoginLog = this.getById(id);
		return LoginLog;

	}

	@Override
	public void addLoginLog(LoginLog loginLog) {
		this.save(loginLog);
	}

	@Override
	public void updateLoginLog(LoginLog loginLog) {
		this.updateById(loginLog);
	}

	@Override
	public void deleteLoginLog(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<LoginLog> findLoginLogByConditions(LoginLog loginLog) {
		if(loginLog == null){
			return new ArrayList<>();
		}

		final Wrapper<LoginLog> wrapper = this.retrievalConditionStructure(loginLog);


		final List<LoginLog> loginLogList = this.list(wrapper);


		return loginLogList;
	}

	@Override
	public PageResult<LoginLog> findByPage(PageLoginLogRequestVo vo) {

		final HashMap<String, Object> loginLogms = new HashMap<>();
		loginLogms.put(PageConstant.PAGE,vo.getPage());
		loginLogms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<LoginLog> page = this.page(new Query<LoginLog>().getPage(loginLogms),new QueryWrapper<LoginLog>());

		return new PageResult<LoginLog>(page);
	}

	@Override
	public PageResult<LoginLog> findByPageAndCondition(PageLoginLogRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<LoginLog> wrapper = this.retrievalConditionStructure(vo);

		final IPage<LoginLog> page = this.page(new Query<LoginLog>().getPage(map), wrapper);

		return new PageResult<LoginLog>(page);
	}



	/**
	 * 多条件检索构造
	 * @param loginLog 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<LoginLog> retrievalConditionStructure(LoginLog loginLog){
		final QueryWrapper<LoginLog> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(loginLog.getLoginName())) {
			wrapper.like("login_name",loginLog.getLoginName());
		}

		if (StringUtils.isNotBlank(loginLog.getBrowserName())){
			wrapper.like("browser_name",loginLog.getBrowserName());
		}

		if (StringUtils.isNotBlank(loginLog.getIp())){
			wrapper.like("ip",loginLog.getIp());
		}

		if (StringUtils.isNotBlank(loginLog.getLocation())) {
			wrapper.like("location",loginLog.getLocation());
		}

		if (loginLog.getId() != null) {
			wrapper.eq("id", loginLog.getId());
		}

		return wrapper;
	}

	public Wrapper<LoginLog> retrievalConditionStructure(PageLoginLogRequestVo loginLog){
		final QueryWrapper<LoginLog> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(loginLog.getLoginName())) {
			wrapper.like("login_name",loginLog.getLoginName());
        }

		if (StringUtils.isNotBlank(loginLog.getBrowserName())){
			wrapper.like("browser_name",loginLog.getBrowserName());
		}

		if (StringUtils.isNotBlank(loginLog.getIp())){
			wrapper.like("ip",loginLog.getIp());
		}

		if (StringUtils.isNotBlank(loginLog.getLocation())) {
			wrapper.like("location",loginLog.getLocation());
        }

		if (loginLog.getId() != null) {
			wrapper.eq("id", loginLog.getId());
        }

		return wrapper;
	}
}

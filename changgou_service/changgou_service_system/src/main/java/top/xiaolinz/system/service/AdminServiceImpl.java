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
import top.xiaolinz.system_api.entity.Admin;
import top.xiaolinz.system.mapper.AdminMapper;
import top.xiaolinz.system_api.service.AdminService;
import top.xiaolinz.system_api.vo.PageAdminRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{
	@Override
	public List<Admin> findAll() {

		return this.list();
	}

	@Override
	public Admin findAdminById(Integer id) {

		final Admin Admin = this.getById(id);
		return Admin;

	}

	@Override
	public void addAdmin(Admin admin) {
		this.save(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		this.updateById(admin);
	}

	@Override
	public void deleteAdmin(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Admin> findAdminByConditions(Admin admin) {
		if(admin == null){
			return new ArrayList<>();
		}

		final Wrapper<Admin> wrapper = this.retrievalConditionStructure(admin);


		final List<Admin> adminList = this.list(wrapper);


		return adminList;
	}

	@Override
	public PageResult<Admin> findByPage(PageAdminRequestVo vo) {

		final HashMap<String, Object> adminms = new HashMap<>();
		adminms.put(PageConstant.PAGE,vo.getPage());
		adminms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Admin> page = this.page(new Query<Admin>().getPage(adminms),new QueryWrapper<Admin>());

		return new PageResult<Admin>(page);
	}

	@Override
	public PageResult<Admin> findByPageAndCondition(PageAdminRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Admin> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Admin> page = this.page(new Query<Admin>().getPage(map), wrapper);

		return new PageResult<Admin>(page);
	}



	/**
	 * 多条件检索构造
	 * @param admin 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Admin> retrievalConditionStructure(Admin admin){
		final QueryWrapper<Admin> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(admin.getLoginName())) {
			wrapper.like("login_name",admin.getLoginName());
		}

		if (StringUtils.isNotBlank(admin.getPassword())){
			wrapper.like("password", admin.getPassword());
		}

		if(admin.getId() != null){
			wrapper.eq("id", admin.getId());

		}

		if (admin.getStatus() != null){
			wrapper.eq("status", admin.getStatus());
		}

		return wrapper;
	}

	public Wrapper<Admin> retrievalConditionStructure(PageAdminRequestVo admin){
		final QueryWrapper<Admin> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(admin.getLoginName())) {
			wrapper.like("login_name",admin.getLoginName());
        }

		if (StringUtils.isNotBlank(admin.getPassword())){
			wrapper.like("password", admin.getPassword());
		}

		if(admin.getId() != null){
			wrapper.eq("id", admin.getId());

		}

		if (admin.getStatus() != null){
			wrapper.eq("status", admin.getStatus());
		}

		return wrapper;
	}
}

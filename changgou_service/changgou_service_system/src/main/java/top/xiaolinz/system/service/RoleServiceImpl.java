package top.xiaolinz.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.common_db.constant.PageConstant;
import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.common_db.utils.Query;
import top.xiaolinz.system_api.entity.Role;
import top.xiaolinz.system_api.entity.Role;
import top.xiaolinz.system.mapper.RoleMapper;
import top.xiaolinz.system_api.service.RoleService;
import top.xiaolinz.system_api.vo.PageRoleRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{
	@Override
	public List<top.xiaolinz.system_api.entity.Role> findAll() {

		return this.list();
	}

	@Override
	public top.xiaolinz.system_api.entity.Role findRoleById(Integer id) {

		final top.xiaolinz.system_api.entity.Role Role = this.getById(id);
		return Role;

	}

	@Override
	public void addRole(top.xiaolinz.system_api.entity.Role role) {
		this.save(role);
	}

	@Override
	public void updateRole(top.xiaolinz.system_api.entity.Role role) {
		this.updateById(role);
	}

	@Override
	public void deleteRole(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<top.xiaolinz.system_api.entity.Role> findRoleByConditions(top.xiaolinz.system_api.entity.Role role) {
		if(role == null){
			return new ArrayList<>();
		}

		final Wrapper<top.xiaolinz.system_api.entity.Role> wrapper = this.retrievalConditionStructure(role);


		final List<top.xiaolinz.system_api.entity.Role> roleList = this.list(wrapper);


		return roleList;
	}

	@Override
	public PageResult<top.xiaolinz.system_api.entity.Role> findByPage(PageRoleRequestVo vo) {

		final HashMap<String, Object> rolems = new HashMap<>();
		rolems.put(PageConstant.PAGE,vo.getPage());
		rolems.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<top.xiaolinz.system_api.entity.Role> page = this.page(new Query<top.xiaolinz.system_api.entity.Role>().getPage(rolems),new QueryWrapper<top.xiaolinz.system_api.entity.Role>());

		return new PageResult<top.xiaolinz.system_api.entity.Role>(page);
	}

	@Override
	public PageResult<top.xiaolinz.system_api.entity.Role> findByPageAndCondition(PageRoleRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<top.xiaolinz.system_api.entity.Role> wrapper = this.retrievalConditionStructure(vo);

		final IPage<top.xiaolinz.system_api.entity.Role> page = this.page(new Query<top.xiaolinz.system_api.entity.Role>().getPage(map), wrapper);

		return new PageResult<top.xiaolinz.system_api.entity.Role>(page);
	}



	/**
	 * 多条件检索构造
	 * @param role 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<top.xiaolinz.system_api.entity.Role> retrievalConditionStructure(top.xiaolinz.system_api.entity.Role role){
		final QueryWrapper<top.xiaolinz.system_api.entity.Role> wrapper = new QueryWrapper<>();

		if (role.getId() != null) {
			wrapper.eq("id", role.getId());
		}

		if (StringUtils.isNotBlank(role.getName())) {
			wrapper.like("name", role.getName());
		}

		return wrapper;
	}

	public Wrapper<top.xiaolinz.system_api.entity.Role> retrievalConditionStructure(PageRoleRequestVo role){
		final QueryWrapper<Role> wrapper = new QueryWrapper<>();

		if (role.getId() != null) {
			wrapper.eq("id", role.getId());
        }

		if (StringUtils.isNotBlank(role.getName())) {
			wrapper.like("name", role.getName());
        }

		return wrapper;
	}
}

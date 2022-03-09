package top.xiaolinz.user.service;

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
import top.xiaolinz.user.mapper.UserMapper;
import top.xiaolinz.user_api.entity.User;
import top.xiaolinz.user_api.entity.User;
import top.xiaolinz.user_api.service.UserService;
import top.xiaolinz.user_api.vo.PageUserRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	@Override
	public List<User> findAll() {

		return this.list();
	}

	@Override
	public User findUserById(Integer id) {

		final User User = this.getById(id);
		return User;

	}

	@Override
	public void addUser(User user) {
		this.save(user);
	}

	@Override
	public void updateUser(User user) {
		this.updateById(user);
	}

	@Override
	public void deleteUser(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<User> findUserByConditions(User user) {
		if(user == null){
			return new ArrayList<>();
		}

		final Wrapper<User> wrapper = this.retrievalConditionStructure(user);


		final List<User> userList = this.list(wrapper);


		return userList;
	}

	@Override
	public PageResult<User> findByPage(PageUserRequestVo vo) {

		final HashMap<String, Object> userms = new HashMap<>();
		userms.put(PageConstant.PAGE,vo.getPage());
		userms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<User> page = this.page(new Query<User>().getPage(userms),new QueryWrapper<User>());

		return new PageResult<User>(page);
	}

	@Override
	public PageResult<User> findByPageAndCondition(PageUserRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<User> wrapper = this.retrievalConditionStructure(vo);

		final IPage<User> page = this.page(new Query<User>().getPage(map), wrapper);

		return new PageResult<User>(page);
	}



	/**
	 * 多条件检索构造
	 * @param user 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<User> retrievalConditionStructure(User user){
		final QueryWrapper<User> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(user.getUsername())) {
			wrapper.eq("username", user.getUsername());
		}

		if (StringUtils.isNotBlank(user.getPassword())){
			wrapper.eq("password",user.getPassword());
		}

		if (StringUtils.isNotBlank(user.getPhone())){
			wrapper.like("phone",user.getPhone());
		}

		if (StringUtils.isNotBlank(user.getEmail())){
			wrapper.like("email",user.getEmail());
		}

		if (StringUtils.isNotBlank(user.getSourceType())) {
			wrapper.eq("source_type",user.getSourceType());
		}

		if (StringUtils.isNotBlank(user.getNickName())){
			wrapper.like("nick_name",user.getNickName());
		}

		if (StringUtils.isNotBlank(user.getName())) {
			wrapper.like("name", user.getName());
		}

		if (StringUtils.isNotBlank(user.getStatus())) {
			wrapper.eq("status", user.getStatus());
		}

		if (StringUtils.isNotBlank(user.getHeadPic())) {
			wrapper.like("head_pic",user.getHeadPic());
		}

		if (StringUtils.isNotBlank(user.getQq())) {
			wrapper.like("qq",user.getQq());
		}

		if (StringUtils.isNotBlank(user.getIsMobileCheck())) {
			wrapper.eq("is_mobile_check",user.getIsMobileCheck());
		}

		if (StringUtils.isNotBlank(user.getIsEmailCheck())) {
			wrapper.eq("is_email_check",user.getIsEmailCheck());
		}

		if (StringUtils.isNotBlank(user.getSex())) {
			wrapper.eq("sex",user.getSex());
		}

		if (user.getUserLevel() != null) {
			wrapper.eq("user_level",user.getUserLevel());
		}

		if (user.getPoints() != null) {
			wrapper.eq("points",user.getPoints());
		}

		if (user.getExperienceValue() != null) {
			wrapper.eq("experience_value",user.getExperienceValue());
		}

		return wrapper;
	}

	public Wrapper<User> retrievalConditionStructure(PageUserRequestVo user){
		final QueryWrapper<User> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(user.getUsername())) {
			wrapper.eq("username", user.getUsername());
        }

		if (StringUtils.isNotBlank(user.getPassword())){
			wrapper.eq("password",user.getPassword());
		}

		if (StringUtils.isNotBlank(user.getPhone())){
			wrapper.like("phone",user.getPhone());
		}

		if (StringUtils.isNotBlank(user.getEmail())){
			wrapper.like("email",user.getEmail());
		}

		if (StringUtils.isNotBlank(user.getSourceType())) {
			wrapper.eq("source_type",user.getSourceType());
        }

		if (StringUtils.isNotBlank(user.getNickName())){
			wrapper.like("nick_name",user.getNickName());
		}

		if (StringUtils.isNotBlank(user.getName())) {
			wrapper.like("name", user.getName());
        }

		if (StringUtils.isNotBlank(user.getStatus())) {
			wrapper.eq("status", user.getStatus());
        }

		if (StringUtils.isNotBlank(user.getHeadPic())) {
			wrapper.like("head_pic",user.getHeadPic());
        }

		if (StringUtils.isNotBlank(user.getQq())) {
			wrapper.like("qq",user.getQq());
        }

		if (StringUtils.isNotBlank(user.getIsMobileCheck())) {
			wrapper.eq("is_mobile_check",user.getIsMobileCheck());
        }

		if (StringUtils.isNotBlank(user.getIsEmailCheck())) {
			wrapper.eq("is_email_check",user.getIsEmailCheck());
        }

		if (StringUtils.isNotBlank(user.getSex())) {
			wrapper.eq("sex",user.getSex());
        }

		if (user.getUserLevel() != null) {
			wrapper.eq("user_level",user.getUserLevel());
        }

		if (user.getPoints() != null) {
			wrapper.eq("points",user.getPoints());
        }

		if (user.getExperienceValue() != null) {
			wrapper.eq("experience_value",user.getExperienceValue());
        }

		return wrapper;
	}
}

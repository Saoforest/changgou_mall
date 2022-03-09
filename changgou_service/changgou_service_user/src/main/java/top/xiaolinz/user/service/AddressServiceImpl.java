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
import top.xiaolinz.user.mapper.AddressMapper;
import top.xiaolinz.user_api.entity.Address;
import top.xiaolinz.user_api.service.AddressService;
import top.xiaolinz.user_api.vo.PageAddressRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService{
	@Override
	public List<Address> findAll() {

		return this.list();
	}

	@Override
	public Address findAddressById(Integer id) {

		final Address Address = this.getById(id);
		return Address;

	}

	@Override
	public void addAddress(Address address) {
		this.save(address);
	}

	@Override
	public void updateAddress(Address address) {
		this.updateById(address);
	}

	@Override
	public void deleteAddress(Integer id) {
		this.removeById(id);
	}

	@Override
	public List<Address> findAddressByConditions(Address address) {
		if(address == null){
			return new ArrayList<>();
		}

		final Wrapper<Address> wrapper = this.retrievalConditionStructure(address);


		final List<Address> addressList = this.list(wrapper);


		return addressList;
	}

	@Override
	public PageResult<Address> findByPage(PageAddressRequestVo vo) {

		final HashMap<String, Object> addressms = new HashMap<>();
		addressms.put(PageConstant.PAGE,vo.getPage());
		addressms.put(PageConstant.LIMIT,vo.getLimit());

		final IPage<Address> page = this.page(new Query<Address>().getPage(addressms),new QueryWrapper<Address>());

		return new PageResult<Address>(page);
	}

	@Override
	public PageResult<Address> findByPageAndCondition(PageAddressRequestVo vo) {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(PageConstant.PAGE, vo.getPage());
		map.put(PageConstant.LIMIT, vo.getLimit());

		final Wrapper<Address> wrapper = this.retrievalConditionStructure(vo);

		final IPage<Address> page = this.page(new Query<Address>().getPage(map), wrapper);

		return new PageResult<Address>(page);
	}



	/**
	 * 多条件检索构造
	 * @param address 规格参数条件对象
	 * @return 条件对象
	 */
	public Wrapper<Address> retrievalConditionStructure(Address address){
		final QueryWrapper<Address> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(address.getUsername())) {
			wrapper.eq("username",address.getUsername());
		}

		if (StringUtils.isNotBlank(address.getProvinceid())) {
			wrapper.like("provinceid",address.getProvinceid());
		}

		if (StringUtils.isNotBlank(address.getCityid())) {
			wrapper.like("city_id",address.getCityid());
		}

		if (StringUtils.isNotBlank(address.getAreaid())) {
			wrapper.like("areaid",address.getAreaid());
		}

		if (StringUtils.isNotBlank(address.getPhone())) {
			wrapper.like("phone",address.getPhone());
		}

		if (StringUtils.isNotBlank(address.getAddress())) {
			wrapper.like("address",address.getAddress());
		}

		if (StringUtils.isNotBlank(address.getContact())) {
			wrapper.like("contact",address.getContact());
		}

		if (StringUtils.isNotBlank(address.getIsDefault())) {
			wrapper.eq("is_default",address.getIsDefault());
		}

		if (StringUtils.isNotBlank(address.getAlias())) {
			wrapper.like("alias",address.getAlias());
		}

		if (address.getId() != null) {
			wrapper.eq("id", address.getId());
		}

		return wrapper;
	}

	public Wrapper<Address> retrievalConditionStructure(PageAddressRequestVo address){
		final QueryWrapper<Address> wrapper = new QueryWrapper<>();

		if (StringUtils.isNotBlank(address.getUsername())) {
			wrapper.eq("username",address.getUsername());
        }

		if (StringUtils.isNotBlank(address.getProvinceid())) {
			wrapper.like("provinceid",address.getProvinceid());
        }

		if (StringUtils.isNotBlank(address.getCityid())) {
			wrapper.like("city_id",address.getCityid());
        }

		if (StringUtils.isNotBlank(address.getAreaid())) {
			wrapper.like("areaid",address.getAreaid());
        }

		if (StringUtils.isNotBlank(address.getPhone())) {
			wrapper.like("phone",address.getPhone());
        }

		if (StringUtils.isNotBlank(address.getAddress())) {
			wrapper.like("address",address.getAddress());
        }

		if (StringUtils.isNotBlank(address.getContact())) {
			wrapper.like("contact",address.getContact());
        }

		if (StringUtils.isNotBlank(address.getIsDefault())) {
			wrapper.eq("is_default",address.getIsDefault());
        }

		if (StringUtils.isNotBlank(address.getAlias())) {
			wrapper.like("alias",address.getAlias());
        }

		if (address.getId() != null) {
			wrapper.eq("id", address.getId());
        }

		return wrapper;
	}
}

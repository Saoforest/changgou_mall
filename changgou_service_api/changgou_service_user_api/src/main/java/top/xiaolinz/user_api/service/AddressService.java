package top.xiaolinz.user_api.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import top.xiaolinz.common_db.utils.PageResult;
import top.xiaolinz.user_api.entity.Address;
import top.xiaolinz.user_api.vo.PageAddressRequestVo;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
public interface AddressService extends IService<Address>{

    /**
     * 查询所有address
     *
     * @return address集合
     */
    List<Address> findAll();


    /**
     * 根据id查询对应address
     * @param id addressId
     * @return address对象
     */
    Address findAddressById(Integer id);


    /**
     * 添加数据
     * @param Address 数据信息
     */
    void addAddress(Address address);

    /**
     * 修改数据
     * @param Address 数据对象
     */
    void updateAddress(Address address);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteAddress(Integer id);

    /**
     * 条件查询数据
     * @param Address 数据条件信息
     * @return 查询到的数据集
     */
    List<Address> findAddressByConditions(Address address);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Address> findByPage(PageAddressRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Address> findByPageAndCondition(PageAddressRequestVo vo);

    /**
     * 根据登录人获取收件信息
     * @return 收件信息集合
     */
    List<Address> findAddressListByUsername();
}

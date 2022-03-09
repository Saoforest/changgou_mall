package top.xiaolinz.config.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.config.mapper.AddressMapper;
import top.xiaolinz.config_api.entity.Address;
import top.xiaolinz.config_api.service.AddressService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:45
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService{

}

package top.xiaolinz.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.system_api.entity.AdminRole;
import top.xiaolinz.system.mapper.AdminRoleMapper;
import top.xiaolinz.system_api.service.AdminRoleService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService{

}

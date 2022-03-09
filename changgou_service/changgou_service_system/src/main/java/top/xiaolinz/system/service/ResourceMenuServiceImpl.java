package top.xiaolinz.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.system.mapper.ResourceMenuMapper;
import top.xiaolinz.system_api.entity.ResourceMenu;
import top.xiaolinz.system_api.service.ResourceMenuService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class ResourceMenuServiceImpl extends ServiceImpl<ResourceMenuMapper, ResourceMenu> implements ResourceMenuService{

}

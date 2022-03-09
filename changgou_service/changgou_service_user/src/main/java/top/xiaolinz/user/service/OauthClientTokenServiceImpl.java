package top.xiaolinz.user.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.user_api.entity.OauthClientToken;
import top.xiaolinz.user.mapper.OauthClientTokenMapper;
import top.xiaolinz.user_api.service.OauthClientTokenService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class OauthClientTokenServiceImpl extends ServiceImpl<OauthClientTokenMapper, OauthClientToken> implements OauthClientTokenService{

}

package top.xiaolinz.config.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.config.mapper.OauthRefreshTokenMapper;
import top.xiaolinz.config_api.entity.OauthRefreshToken;
import top.xiaolinz.config_api.service.OauthRefreshTokenService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:45
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class OauthRefreshTokenServiceImpl extends ServiceImpl<OauthRefreshTokenMapper, OauthRefreshToken> implements OauthRefreshTokenService{

}

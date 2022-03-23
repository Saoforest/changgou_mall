package top.xiaolinz.oauth.service;

import top.xiaolinz.oauth.util.AuthToken;

/**
 * @author XiaoLin
 * @date 2022/3/22 16:57
 * @blog https://www.xiaolinz.top/
 * 
 *       使用oauth的密码模式实现认证
 **/
public interface AuthService {

    AuthToken login(String username, String password, String clientId, String clientSecret);
}

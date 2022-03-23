package top.xiaolinz.web.service.impl;

import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import top.xiaolinz.web.service.AuthService;

/**
 * @author XiaoLin
 * @date 2022/3/23 18:01
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String getJtiFromCookie(ServerHttpRequest request) {
        final HttpCookie cookie = request.getCookies().getFirst("uid");
        return cookie == null ? null : cookie.getValue();
    }
}

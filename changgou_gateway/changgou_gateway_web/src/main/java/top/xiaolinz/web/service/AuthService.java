package top.xiaolinz.web.service;

import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @author XiaoLin
 * @date 2022/3/23 18:00
 * @blog https://www.xiaolinz.top/
 **/
public interface AuthService {

    /**
     * 从cookie中获取jti
     * 
     * @param request
     *            请求对象
     * @return jti
     */
    String getJtiFromCookie(ServerHttpRequest request);
}

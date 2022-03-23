package top.xiaolinz.oauth.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.RedisUtils;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.oauth.service.AuthService;
import top.xiaolinz.oauth.util.AuthToken;

/**
 * @author XiaoLin
 * @date 2022/3/22 16:59
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${auth.ttl}")
    private Integer ttl;

    @Override
    public AuthToken login(String username, String password, String clientId, String clientSecret) {
        final ServiceInstance choose = this.client.choose("user-auth");
        final StringBuilder builder = new StringBuilder();
        String path = "/oauth/token";
        builder.append(choose.getUri()).append(path);
        final HashMap<String, Object> map = new HashMap<>();
        // 指定oauth获取token模式
        map.put("grant_type", "password");
        // 用户名
        map.put("username", username);
        // 密码
        map.put("password", password);
        final HttpResponse response =
            HttpRequest.post(builder.toString()).basicAuth(clientId, clientSecret).form(map).execute();
        final String body = response.body();
        if (response.getStatus() == 400 || response.getStatus() == 401) {
            throw new BusinessException(StatusCode.ERROR, "申请令牌失败");
        }
        final AuthToken token = JSONUtil.toBean(body, AuthToken.class);

        // 令牌存储至redis
        this.redisUtils.set(token.getJti(), token.getAccessToken(), this.ttl);

        return token;
    }
}

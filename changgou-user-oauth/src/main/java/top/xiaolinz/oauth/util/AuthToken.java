package top.xiaolinz.oauth.util;

import java.io.Serializable;

public class AuthToken implements Serializable {

    // 令牌信息
    String accessToken;
    // 刷新token(refresh_token)
    String refreshToken;
    // jwt短令牌
    String jti;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getJti() {
        return this.jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
package top.xiaolinz.user_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "oauth_client_details")
public class OauthClientDetails implements Serializable {
    /**
     * 客户端ID，主要用于标识对应的应用
     */
    @TableId(value = "client_id", type = IdType.AUTO)
    private String clientId;

    @TableField(value = "resource_ids")
    private String resourceIds;

    /**
     * 客户端秘钥，BCryptPasswordEncoder加密
     */
    @TableField(value = "client_secret")
    private String clientSecret;

    /**
     * 对应的范围
     */
    @TableField(value = "`scope`")
    private String scope;

    /**
     * 认证模式
     */
    @TableField(value = "authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * 认证后重定向地址
     */
    @TableField(value = "web_server_redirect_uri")
    private String webServerRedirectUri;

    @TableField(value = "authorities")
    private String authorities;

    /**
     * 令牌有效期
     */
    @TableField(value = "access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 令牌刷新周期
     */
    @TableField(value = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @TableField(value = "additional_information")
    private String additionalInformation;

    @TableField(value = "autoapprove")
    private String autoapprove;

    private static final long serialVersionUID = 1L;

    public static final String COL_CLIENT_ID = "client_id";

    public static final String COL_RESOURCE_IDS = "resource_ids";

    public static final String COL_CLIENT_SECRET = "client_secret";

    public static final String COL_SCOPE = "scope";

    public static final String COL_AUTHORIZED_GRANT_TYPES = "authorized_grant_types";

    public static final String COL_WEB_SERVER_REDIRECT_URI = "web_server_redirect_uri";

    public static final String COL_AUTHORITIES = "authorities";

    public static final String COL_ACCESS_TOKEN_VALIDITY = "access_token_validity";

    public static final String COL_REFRESH_TOKEN_VALIDITY = "refresh_token_validity";

    public static final String COL_ADDITIONAL_INFORMATION = "additional_information";

    public static final String COL_AUTOAPPROVE = "autoapprove";
}
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
@TableName(value = "oauth_access_token")
public class OauthAccessToken implements Serializable {
    @TableId(value = "authentication_id", type = IdType.AUTO)
    private String authenticationId;

    @TableField(value = "token_id")
    private String tokenId;

    @TableField(value = "token")
    private byte[] token;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "client_id")
    private String clientId;

    @TableField(value = "authentication")
    private byte[] authentication;

    @TableField(value = "refresh_token")
    private String refreshToken;

    private static final long serialVersionUID = 1L;

    public static final String COL_AUTHENTICATION_ID = "authentication_id";

    public static final String COL_TOKEN_ID = "token_id";

    public static final String COL_TOKEN = "token";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_CLIENT_ID = "client_id";

    public static final String COL_AUTHENTICATION = "authentication";

    public static final String COL_REFRESH_TOKEN = "refresh_token";
}
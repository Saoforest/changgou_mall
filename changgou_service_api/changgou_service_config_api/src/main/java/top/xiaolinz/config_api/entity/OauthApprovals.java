package top.xiaolinz.config_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:45
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "oauth_approvals")
public class OauthApprovals implements Serializable {
    @TableField(value = "userId")
    private String userid;

    @TableField(value = "clientId")
    private String clientid;

    @TableField(value = "`scope`")
    private String scope;

    @TableField(value = "`status`")
    private String status;

    @TableField(value = "expiresAt")
    private Date expiresat;

    @TableField(value = "lastModifiedAt")
    private Date lastmodifiedat;

    private static final long serialVersionUID = 1L;

    public static final String COL_USERID = "userId";

    public static final String COL_CLIENTID = "clientId";

    public static final String COL_SCOPE = "scope";

    public static final String COL_STATUS = "status";

    public static final String COL_EXPIRESAT = "expiresAt";

    public static final String COL_LASTMODIFIEDAT = "lastModifiedAt";
}
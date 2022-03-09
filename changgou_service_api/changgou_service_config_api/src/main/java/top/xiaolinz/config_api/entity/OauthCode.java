package top.xiaolinz.config_api.entity;

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
* @date 2022/3/8 23:45
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "oauth_code")
public class OauthCode implements Serializable {
    @TableField(value = "code")
    private String code;

    @TableField(value = "authentication")
    private byte[] authentication;

    private static final long serialVersionUID = 1L;

    public static final String COL_CODE = "code";

    public static final String COL_AUTHENTICATION = "authentication";
}
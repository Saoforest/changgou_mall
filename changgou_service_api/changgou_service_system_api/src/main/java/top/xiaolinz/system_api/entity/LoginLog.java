package top.xiaolinz.system_api.entity;

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
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_login_log")
public class LoginLog implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "login_name")
    private String loginName;

    @TableField(value = "ip")
    private String ip;

    @TableField(value = "browser_name")
    private String browserName;

    /**
     * 地区
     */
    @TableField(value = "`location`")
    private String location;

    /**
     * 登录时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_LOGIN_NAME = "login_name";

    public static final String COL_IP = "ip";

    public static final String COL_BROWSER_NAME = "browser_name";

    public static final String COL_LOCATION = "location";

    public static final String COL_LOGIN_TIME = "login_time";
}
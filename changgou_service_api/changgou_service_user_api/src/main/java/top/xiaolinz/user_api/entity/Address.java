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
@TableName(value = "tb_address")
public class Address implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 省
     */
    @TableField(value = "provinceid")
    private String provinceid;

    /**
     * 市
     */
    @TableField(value = "cityid")
    private String cityid;

    /**
     * 县/区
     */
    @TableField(value = "areaid")
    private String areaid;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 联系人
     */
    @TableField(value = "contact")
    private String contact;

    /**
     * 是否是默认 1默认 0否
     */
    @TableField(value = "is_default")
    private String isDefault;

    /**
     * 别名
     */
    @TableField(value = "`alias`")
    private String alias;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PROVINCEID = "provinceid";

    public static final String COL_CITYID = "cityid";

    public static final String COL_AREAID = "areaid";

    public static final String COL_PHONE = "phone";

    public static final String COL_ADDRESS = "address";

    public static final String COL_CONTACT = "contact";

    public static final String COL_IS_DEFAULT = "is_default";

    public static final String COL_ALIAS = "alias";
}
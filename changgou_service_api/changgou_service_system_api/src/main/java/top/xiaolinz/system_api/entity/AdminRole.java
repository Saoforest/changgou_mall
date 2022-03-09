package top.xiaolinz.system_api.entity;

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
* @date 2022/3/8 23:51
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_admin_role")
public class AdminRole implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 管理员ID
     */
    @TableField(value = "admin_id")
    private Integer adminId;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ADMIN_ID = "admin_id";

    public static final String COL_ROLE_ID = "role_id";
}
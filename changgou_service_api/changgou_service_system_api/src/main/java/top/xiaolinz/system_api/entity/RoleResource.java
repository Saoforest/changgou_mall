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
@TableName(value = "tb_role_resource")
public class RoleResource implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "role_id")
    private Integer roleId;

    @TableField(value = "resource_id")
    private Integer resourceId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_RESOURCE_ID = "resource_id";
}
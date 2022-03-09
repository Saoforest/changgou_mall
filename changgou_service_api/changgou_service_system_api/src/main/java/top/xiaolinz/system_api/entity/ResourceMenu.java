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
@TableName(value = "tb_resource_menu")
public class ResourceMenu implements Serializable {

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "resource_id")
    private Integer resourceId;

    @TableField(value = "menu_id")
    private String menuId;

    private static final long serialVersionUID = 1L;

    public static final String COL_RESOURCE_ID = "resource_id";

    public static final String COL_MENU_ID = "menu_id";
}
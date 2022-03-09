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
@TableName(value = "tb_resource")
public class Resource implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "res_key")
    private String resKey;

    @TableField(value = "res_name")
    private String resName;

    @TableField(value = "parent_id")
    private Integer parentId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_RES_KEY = "res_key";

    public static final String COL_RES_NAME = "res_name";

    public static final String COL_PARENT_ID = "parent_id";
}
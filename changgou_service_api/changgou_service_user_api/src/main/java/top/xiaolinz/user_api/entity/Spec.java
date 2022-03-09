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
@TableName(value = "tb_spec")
public class Spec implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 规格选项
     */
    @TableField(value = "`options`")
    private String options;

    /**
     * 排序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 模板ID
     */
    @TableField(value = "template_id")
    private Integer templateId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_OPTIONS = "options";

    public static final String COL_SEQ = "seq";

    public static final String COL_TEMPLATE_ID = "template_id";
}
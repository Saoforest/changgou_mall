package top.xiaolinz.order_api.entity;

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
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_return_cause")
public class ReturnCause implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 原因
     */
    @TableField(value = "cause")
    private String cause;

    /**
     * 排序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 是否启用
     */
    @TableField(value = "`status`")
    private String status;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CAUSE = "cause";

    public static final String COL_SEQ = "seq";

    public static final String COL_STATUS = "status";
}
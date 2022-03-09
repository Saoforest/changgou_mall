package top.xiaolinz.order_api.entity;

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
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_preferential")
public class Preferential implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消费金额
     */
    @TableField(value = "buy_money")
    private Integer buyMoney;

    /**
     * 优惠金额
     */
    @TableField(value = "pre_money")
    private Integer preMoney;

    /**
     * 品类ID
     */
    @TableField(value = "category_id")
    private Integer categoryId;

    /**
     * 活动开始日期
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 活动截至日期
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 状态
     */
    @TableField(value = "`state`")
    private String state;

    /**
     * 类型1不翻倍 2翻倍
     */
    @TableField(value = "`type`")
    private String type;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_BUY_MONEY = "buy_money";

    public static final String COL_PRE_MONEY = "pre_money";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_STATE = "state";

    public static final String COL_TYPE = "type";
}
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
@TableName(value = "tb_order_log")
public class OrderLog implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 操作员
     */
    @TableField(value = "operater")
    private String operater;

    /**
     * 操作时间
     */
    @TableField(value = "operate_time")
    private Date operateTime;

    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    private String orderStatus;

    /**
     * 付款状态
     */
    @TableField(value = "pay_status")
    private String payStatus;

    /**
     * 发货状态
     */
    @TableField(value = "consign_status")
    private String consignStatus;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_OPERATER = "operater";

    public static final String COL_OPERATE_TIME = "operate_time";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_STATUS = "order_status";

    public static final String COL_PAY_STATUS = "pay_status";

    public static final String COL_CONSIGN_STATUS = "consign_status";

    public static final String COL_REMARKS = "remarks";
}
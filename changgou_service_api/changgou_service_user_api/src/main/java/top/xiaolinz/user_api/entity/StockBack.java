package top.xiaolinz.user_api.entity;

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
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_stock_back")
public class StockBack implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private String orderId;

    /**
     * SKU的id
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private String skuId;

    /**
     * 回滚数量
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 回滚状态
     */
    @TableField(value = "`status`")
    private String status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 回滚时间
     */
    @TableField(value = "back_time")
    private Date backTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_NUM = "num";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_BACK_TIME = "back_time";
}
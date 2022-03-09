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
@TableName(value = "tb_order_config")
public class OrderConfig implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 正常订单超时时间（分）
     */
    @TableField(value = "order_timeout")
    private Integer orderTimeout;

    /**
     * 秒杀订单超时时间（分）
     */
    @TableField(value = "seckill_timeout")
    private Integer seckillTimeout;

    /**
     * 自动收货（天）
     */
    @TableField(value = "take_timeout")
    private Integer takeTimeout;

    /**
     * 售后期限
     */
    @TableField(value = "service_timeout")
    private Integer serviceTimeout;

    /**
     * 自动五星好评
     */
    @TableField(value = "comment_timeout")
    private Integer commentTimeout;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_TIMEOUT = "order_timeout";

    public static final String COL_SECKILL_TIMEOUT = "seckill_timeout";

    public static final String COL_TAKE_TIMEOUT = "take_timeout";

    public static final String COL_SERVICE_TIMEOUT = "service_timeout";

    public static final String COL_COMMENT_TIMEOUT = "comment_timeout";
}
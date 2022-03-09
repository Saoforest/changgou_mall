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
@TableName(value = "tb_task")
public class Task implements Serializable {
    /**
     * 任务id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "delete_time")
    private Date deleteTime;

    /**
     * 任务类型
     */
    @TableField(value = "task_type")
    private String taskType;

    /**
     * 交换机名称
     */
    @TableField(value = "mq_exchange")
    private String mqExchange;

    /**
     * routingkey
     */
    @TableField(value = "mq_routingkey")
    private String mqRoutingkey;

    /**
     * 任务请求的内容
     */
    @TableField(value = "request_body")
    private String requestBody;

    /**
     * 任务状态
     */
    @TableField(value = "`status`")
    private String status;

    /**
     * 任务错误信息
     */
    @TableField(value = "errormsg")
    private String errormsg;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DELETE_TIME = "delete_time";

    public static final String COL_TASK_TYPE = "task_type";

    public static final String COL_MQ_EXCHANGE = "mq_exchange";

    public static final String COL_MQ_ROUTINGKEY = "mq_routingkey";

    public static final String COL_REQUEST_BODY = "request_body";

    public static final String COL_STATUS = "status";

    public static final String COL_ERRORMSG = "errormsg";
}
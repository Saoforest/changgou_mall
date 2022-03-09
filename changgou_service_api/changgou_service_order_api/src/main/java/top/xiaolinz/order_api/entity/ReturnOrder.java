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
@TableName(value = "tb_return_order")
public class ReturnOrder implements Serializable {
    /**
     * 服务单号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 订单号
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 申请时间
     */
    @TableField(value = "apply_time")
    private Date applyTime;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 用户账号
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 联系人
     */
    @TableField(value = "linkman")
    private String linkman;

    /**
     * 联系人手机
     */
    @TableField(value = "linkman_mobile")
    private String linkmanMobile;

    /**
     * 类型
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 退款金额
     */
    @TableField(value = "return_money")
    private Integer returnMoney;

    /**
     * 是否退运费
     */
    @TableField(value = "is_return_freight")
    private String isReturnFreight;

    /**
     * 申请状态
     */
    @TableField(value = "`status`")
    private String status;

    /**
     * 处理时间
     */
    @TableField(value = "dispose_time")
    private Date disposeTime;

    /**
     * 退货退款原因
     */
    @TableField(value = "return_cause")
    private Integer returnCause;

    /**
     * 凭证图片
     */
    @TableField(value = "evidence")
    private String evidence;

    /**
     * 问题描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 处理备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 管理员id
     */
    @TableField(value = "admin_id")
    private Integer adminId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_APPLY_TIME = "apply_time";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USER_ACCOUNT = "user_account";

    public static final String COL_LINKMAN = "linkman";

    public static final String COL_LINKMAN_MOBILE = "linkman_mobile";

    public static final String COL_TYPE = "type";

    public static final String COL_RETURN_MONEY = "return_money";

    public static final String COL_IS_RETURN_FREIGHT = "is_return_freight";

    public static final String COL_STATUS = "status";

    public static final String COL_DISPOSE_TIME = "dispose_time";

    public static final String COL_RETURN_CAUSE = "return_cause";

    public static final String COL_EVIDENCE = "evidence";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_REMARK = "remark";

    public static final String COL_ADMIN_ID = "admin_id";
}
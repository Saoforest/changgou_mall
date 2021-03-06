package top.xiaolinz.order_api.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName(value = "tb_order")
public class Order implements Serializable {

    public static final String COL_ID = "id";
    public static final String COL_TOTAL_NUM = "total_num";
    public static final String COL_TOTAL_MONEY = "total_money";
    public static final String COL_PRE_MONEY = "pre_money";
    public static final String COL_POST_FEE = "post_fee";
    public static final String COL_PAY_MONEY = "pay_money";
    public static final String COL_PAY_TYPE = "pay_type";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_PAY_TIME = "pay_time";
    public static final String COL_CONSIGN_TIME = "consign_time";
    public static final String COL_END_TIME = "end_time";
    public static final String COL_CLOSE_TIME = "close_time";
    public static final String COL_SHIPPING_NAME = "shipping_name";
    public static final String COL_SHIPPING_CODE = "shipping_code";
    public static final String COL_USERNAME = "username";
    public static final String COL_BUYER_MESSAGE = "buyer_message";
    public static final String COL_BUYER_RATE = "buyer_rate";
    public static final String COL_RECEIVER_CONTACT = "receiver_contact";
    public static final String COL_RECEIVER_MOBILE = "receiver_mobile";
    public static final String COL_RECEIVER_ADDRESS = "receiver_address";
    public static final String COL_SOURCE_TYPE = "source_type";
    public static final String COL_TRANSACTION_ID = "transaction_id";
    public static final String COL_ORDER_STATUS = "order_status";
    public static final String COL_PAY_STATUS = "pay_status";
    public static final String COL_CONSIGN_STATUS = "consign_status";
    public static final String COL_IS_DELETE = "is_delete";
    private static final long serialVersionUID = 1L;
    /**
     * ??????id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * ????????????
     */
    @TableField(value = "total_num")
    private Integer totalNum;
    /**
     * ????????????
     */
    @TableField(value = "total_money")
    private Integer totalMoney;
    /**
     * ????????????
     */
    @TableField(value = "pre_money")
    private Integer preMoney;
    /**
     * ??????
     */
    @TableField(value = "post_fee")
    private Integer postFee;
    /**
     * ????????????
     */
    @TableField(value = "pay_money")
    private Integer payMoney;
    /**
     * ???????????????1??????????????????0 ????????????
     */
    @TableField(value = "pay_type")
    private String payType;
    /**
     * ??????????????????
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * ??????????????????
     */
    @TableField(value = "update_time")
    private Date updateTime;
    /**
     * ????????????
     */
    @TableField(value = "pay_time")
    private Date payTime;
    /**
     * ????????????
     */
    @TableField(value = "consign_time")
    private Date consignTime;
    /**
     * ??????????????????
     */
    @TableField(value = "end_time")
    private Date endTime;
    /**
     * ??????????????????
     */
    @TableField(value = "close_time")
    private Date closeTime;
    /**
     * ????????????
     */
    @TableField(value = "shipping_name")
    private String shippingName;
    /**
     * ????????????
     */
    @TableField(value = "shipping_code")
    private String shippingCode;
    /**
     * ????????????
     */
    @TableField(value = "username")
    private String username;
    /**
     * ????????????
     */
    @TableField(value = "buyer_message")
    private String buyerMessage;
    /**
     * ????????????
     */
    @TableField(value = "buyer_rate")
    private String buyerRate;
    /**
     * ?????????
     */
    @TableField(value = "receiver_contact")
    private String receiverContact;
    /**
     * ???????????????
     */
    @TableField(value = "receiver_mobile")
    private String receiverMobile;
    /**
     * ???????????????
     */
    @TableField(value = "receiver_address")
    private String receiverAddress;
    /**
     * ???????????????1:web???2???app???3?????????????????????4??????????????????  5 H5????????????
     */
    @TableField(value = "source_type")
    private String sourceType;
    /**
     * ???????????????
     */
    @TableField(value = "transaction_id")
    private String transactionId;
    /**
     * ????????????
     */
    @TableField(value = "order_status")
    private String orderStatus;
    /**
     * ???????????? 0:????????? 1:?????????
     */
    @TableField(value = "pay_status")
    private String payStatus;
    /**
     * ???????????? 0:????????? 1:????????? 2:?????????
     */
    @TableField(value = "consign_status")
    private String consignStatus;
    /**
     * ????????????
     */
    @TableField(value = "is_delete")
    private String isDelete;
}
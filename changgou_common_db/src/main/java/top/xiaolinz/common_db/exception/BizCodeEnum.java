package top.xiaolinz.common_db.exception;

import lombok.Getter;

/**
 * @author XiaoLin
 * @date 2021/12/31 17:19
 * @blog https://www.xiaolinz.top/ 错误码和错误信息定义类 1. 错误码定义规则为 5 为数字 2. 前两位表示业务场景，最后三位表示错误码。例如：100001。10:通用 001:系统未知 异常
 *
 *       3. 维护错误码后需要维护错误描述，将他们定义为枚举形式 错误码列表： 10: 通用 001：参数格式校验 11: 商品 12: 订单 13: 购物车 14: 物流
 **/
@Getter
public enum BizCodeEnum {
    /**
     * 系统异常
     * 
     * @code: 状态码 @msg: 提示信息
     */
    UNKNOW_EXCEPTION(10000, "系统未知异常"),
    /**
     * 参数校验异常
     * 
     * @code: 状态码 @msg: 提示信息
     */
    VAILD_EXCEPTION(10001, "参数格式校验失败"),

    /**
     * 商品上架异常
     */
    PRODUCT_UP_EXCEPTION(11000,"商品上架异常");

    private final int code;
    private final String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

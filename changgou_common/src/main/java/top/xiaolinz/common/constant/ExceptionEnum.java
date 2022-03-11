package top.xiaolinz.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import top.xiaolinz.common.utils.StatusCode;

/**
 * @author XiaoLin
 * @date 2022/3/11 12:08
 * @blog https://www.xiaolinz.top/
 **/
@AllArgsConstructor
@ToString
@Getter
public enum ExceptionEnum {

	ERROR_SPU_NULL(StatusCode.ERROR,"SPU不存在"),
	ERROR_GOODS_NULL(StatusCode.ERROR,"goods不存在");

	private Integer code;
	private String msg;

}

package top.xiaolinz.goods.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XiaoLin
 * @date 2022/3/7 13:48
 * @blog https://www.xiaolinz.top/
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	// <1> 处理 form data方式调用接口校验失败抛出的异常
	@ExceptionHandler(BindException.class)
	// @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	public R bindExceptionHandler(BindException e) {
		log.error("系统异常{},异常类型{}", e.getMessage(), e.getClass());
		Map<String, Object> body = new LinkedHashMap<>();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<String> messages = fieldErrors.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());
		List<String> fields = fieldErrors.stream().map(o -> o.getField()).collect(Collectors.toList());

		for (int i = 0; i < messages.size(); i++) {
			body.put(fields.get(i), messages.get(i));
		}

		return R.error(StatusCode.ERROR, "校验失败").put("data",body);
	}

	/*
	 * 处理所有校验失败的异常（MethodArgumentNotValidException异常）
	 *
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	// @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	// 设置响应状态码为400
	public R handleBindGetException(MethodArgumentNotValidException ex) {
		log.error("系统异常{},异常类型{}", ex.getMessage(), ex.getClass());

		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("timestamp", new Date());

		// 获取所有异常
		List<String> messages = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		List<String> fields =
				ex.getBindingResult().getFieldErrors().stream().map(x -> x.getField()).collect(Collectors.toList());
		for (int i = 0; i < messages.size(); i++) {
			body.put(fields.get(i), messages.get(i));
		}

		return R.error(StatusCode.ERROR, "校验失败").put("data",body);
	}

	/*
	 * 处理所有参数校验时抛出的异常
	 *
	 * @param e
	 * @return
	 */

	@ExceptionHandler(ConstraintViolationException.class)
	public R handleServiceException(ConstraintViolationException e) {
		log.error("系统异常{},异常类型{}", e.getMessage(), e.getClass());
		Map<String, Object> body = new LinkedHashMap<String, Object>();

		// 获取所有异常
		List<String> messages = new LinkedList<>();
		List<String> fields = new LinkedList<>();
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		for (ConstraintViolation<?> item : violations) {
			messages.add(item.getMessage());

			final String fieldLow = item.getPropertyPath().toString();
			final int i = fieldLow.indexOf(".");
			final String fieldNow = fieldLow.substring(i + 1);
			fields.add(fieldNow);
		}
		for (int i = 0; i < messages.size(); i++) {
			body.put(fields.get(i), messages.get(i));
		}
		return R.error(StatusCode.ERROR, "校验失败").put("data",body);
	}

	// @ExceptionHandler(Throwable.class)
	// @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	public R exception(Throwable e) {
		log.error("系统异常{},异常类型{}", e.getMessage(), e.getClass());

		return R.error(StatusCode.ERROR, "校验失败");
	}
}

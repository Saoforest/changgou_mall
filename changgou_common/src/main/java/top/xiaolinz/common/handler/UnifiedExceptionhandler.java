package top.xiaolinz.common.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.xiaolinz.common.constant.ResponseEnum;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.R;


/**
 * @author XiaoLin
 * @date 2022/3/6 13:56
 * @blog https://www.xiaolinz.top/
 **/

@Slf4j
@RestControllerAdvice
public class UnifiedExceptionhandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleException(Exception e){
        log.error(e.getMessage(), e);
        return R.error();
    }

    // @ExceptionHandler(value = BadSqlGrammarException.class)
    // public R handleException(BadSqlGrammarException e){
    //     log.error(e.getMessage(), e);
    //     return R.setResult(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    // }


    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleException(BusinessException e){
        log.error(e.getMessage(), e);
        return R.error(e.getCode(),e.getMessage());
    }

    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return R.error(ResponseEnum.SERVLET_ERROR.getCode(),ResponseEnum.SERVLET_ERROR.getMessage());
    }
}

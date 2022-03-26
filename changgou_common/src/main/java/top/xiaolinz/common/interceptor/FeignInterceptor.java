package top.xiaolinz.common.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author XiaoLin
 * @date 2022/3/24 20:54
 * @blog https://www.xiaolinz.top/
 *
 * 解决微服务下oauth鉴权feign令牌传递问题
 **/
@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override public void apply(RequestTemplate requestTemplate) {
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null){
            final HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            final Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String headName = headerNames.nextElement();
                if (StringUtils.equals("authorization",headName)){
                    final String authorization = request.getHeader(headName);

//                        传递
                    requestTemplate.header(headName,authorization);
                }
            }

        }
    }
}

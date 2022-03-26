package top.xiaolinz.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author XiaoLin
 * @date 2022/3/23 18:40
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/oauth/login.html").setViewName("login");
    }
}

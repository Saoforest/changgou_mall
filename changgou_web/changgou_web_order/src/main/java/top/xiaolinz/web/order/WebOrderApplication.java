package top.xiaolinz.web.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import top.xiaolinz.common.interceptor.FeignInterceptor;

/**
 * @author XiaoLin
 * @date 2022/3/24 14:57
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {
    "top.xiaolinz"
})
@EnableDiscoveryClient
@EnableFeignClients({"top.xiaolinz.order_api.feign", "top.xiaolinz.user_api.feign"})
public class WebOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebOrderApplication.class, args);
    }

    @Bean
    public FeignInterceptor feignInterceptor() {
        return new FeignInterceptor();
    }
}

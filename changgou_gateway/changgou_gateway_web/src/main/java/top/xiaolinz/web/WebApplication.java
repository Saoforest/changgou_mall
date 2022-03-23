package top.xiaolinz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import top.xiaolinz.common.utils.RedisUtils;

/**
 * @author XiaoLin
 * @date 2022/3/23 16:17
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}

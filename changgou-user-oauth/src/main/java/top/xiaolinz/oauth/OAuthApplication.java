package top.xiaolinz.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import top.xiaolinz.common.utils.RedisUtils;

@SpringBootApplication(scanBasePackages = {"top.xiaolinz"})
@EnableDiscoveryClient
@MapperScan(basePackages = "top.xiaolinz.auth.dao")
@EnableFeignClients(basePackages = {"top.xiaolinz.user_api.feign"})
public class OAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class, args);

    }

    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }

}
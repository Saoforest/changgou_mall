package top.xiaolinz.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XiaoLin
 * @date 2022/3/21 15:56
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }
}

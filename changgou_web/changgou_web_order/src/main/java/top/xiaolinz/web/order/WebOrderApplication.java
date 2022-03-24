package top.xiaolinz.web.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XiaoLin
 * @date 2022/3/24 14:57
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class WebOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebOrderApplication.class, args);
    }
}

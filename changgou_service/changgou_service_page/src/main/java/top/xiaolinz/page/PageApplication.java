package top.xiaolinz.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XiaoLin
 * @date 2022/3/18 17:02
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(scanBasePackages = "top.xiaolinz", exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients("top.xiaolinz.goods_api.feign")
public class PageApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageApplication.class, args);
    }
}

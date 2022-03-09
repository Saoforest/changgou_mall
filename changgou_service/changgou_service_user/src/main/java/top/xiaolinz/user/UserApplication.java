package top.xiaolinz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoLin
 * @date 2022/3/8 23:43
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(scanBasePackages = {"top.xiaolinz" })
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("top.xiaolinz.user.mapper")
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class,args);
	}
}

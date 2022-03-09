package top.xiaolinz.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoLin
 * @date 2022/3/8 23:40
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(scanBasePackages = {"top.xiaolinz" })
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("top.xiaolinz.system.mapper")
public class SystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class,args);
	}
}

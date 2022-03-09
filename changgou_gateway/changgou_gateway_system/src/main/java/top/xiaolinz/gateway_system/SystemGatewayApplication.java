package top.xiaolinz.gateway_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoLin
 * @date 2022/3/9 15:57
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(scanBasePackages = {"top.xiaolinz" })
@EnableEurekaClient
@EnableDiscoveryClient
public class SystemGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemGatewayApplication.class,args);
	}
}

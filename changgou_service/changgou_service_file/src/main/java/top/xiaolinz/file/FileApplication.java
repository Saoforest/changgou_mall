package top.xiaolinz.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoLin
 * @date 2022/3/9 14:07
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(scanBasePackages = {"top.xiaolinz" })
@EnableDiscoveryClient
@EnableEurekaClient
public class FileApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileApplication.class,args);
	}
}

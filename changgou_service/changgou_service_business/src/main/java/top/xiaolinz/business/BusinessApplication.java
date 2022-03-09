package top.xiaolinz.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoLin
 * @date 2022/3/8 23:36
 * @blog https://www.xiaolinz.top/
 **/
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"top.xiaolinz" })
@MapperScan("top.xiaolinz.business.mapper")
public class BusinessApplication {
	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class,args);
	}
}

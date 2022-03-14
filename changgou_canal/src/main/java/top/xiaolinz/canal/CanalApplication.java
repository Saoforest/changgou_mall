package top.xiaolinz.canal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author XiaoLin
 * @date 2022/3/14 12:32
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CanalApplication {
	public static void main(String[] args) {
		SpringApplication.run(CanalApplication.class,args);
	}
}

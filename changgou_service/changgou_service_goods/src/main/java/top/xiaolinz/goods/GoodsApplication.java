package top.xiaolinz.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XiaoLin
 * @date 2022/3/6 13:38
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(basePackages = {"top.xiaolinz.goods.mapper"})
public class GoodsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GoodsApplication.class,args);
	}
}

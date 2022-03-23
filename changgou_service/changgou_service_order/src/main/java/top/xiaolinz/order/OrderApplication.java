package top.xiaolinz.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import top.xiaolinz.common.utils.RedisUtils;

/**
 * @author XiaoLin
 * @date 2022/3/8 23:39
 * @blog https://www.xiaolinz.top/
 **/
@SpringBootApplication(scanBasePackages = {"top.xiaolinz" })
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("top.xiaolinz.order.mapper")
@EnableFeignClients(basePackages = {"top.xiaolinz.goods_api.feign"})
public class OrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class,args);
	}

    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}

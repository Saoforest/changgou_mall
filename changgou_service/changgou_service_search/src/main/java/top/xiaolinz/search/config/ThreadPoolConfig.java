package top.xiaolinz.search.config;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoLin
 * @date 2022/3/13 14:13
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(@Qualifier("threadConfig") ThreadPoolConfigProperties config) {
        return new ThreadPoolExecutor(config.getCoreSize(), config.getMaxSize(), config.getKeepAliveTime(),
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(100000), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    }

}

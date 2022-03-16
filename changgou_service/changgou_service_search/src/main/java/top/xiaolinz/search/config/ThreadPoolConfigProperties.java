package top.xiaolinz.search.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author XiaoLin
 * @date 2022/3/13 14:29
 * @blog https://www.xiaolinz.top/
 **/
@ConfigurationProperties(prefix = "mall.thread")
@Component("threadConfig")
@Data
public class ThreadPoolConfigProperties {
    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;
}

package top.xiaolinz.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import cn.hutool.extra.spring.SpringUtil;


/**
 * @author XiaoLin
 * @date 2022/3/6 13:56
 * @blog https://www.xiaolinz.top/
 **/

public class LogPortConfig extends ClassicConverter {
  private static final Logger logger = LoggerFactory.getLogger(LogPortConfig.class);

  private static String port;

  private static String portPull() {
      if (port == null) {
          final Environment bean = SpringUtil.getBean(Environment.class);
          port = bean.getProperty("server.port");
    }

    return port;
  }

  @Override
  public String convert(ILoggingEvent event) {
      return portPull();
  }
}

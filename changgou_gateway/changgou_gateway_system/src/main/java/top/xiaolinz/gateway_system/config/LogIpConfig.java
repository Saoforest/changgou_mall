package top.xiaolinz.gateway_system.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * @author XiaoLin
 * @date 2022/3/6 13:56
 * @blog https://www.xiaolinz.top/
 **/

public class LogIpConfig extends ClassicConverter {
  private static final Logger logger = LoggerFactory.getLogger(LogIpConfig.class);
  private static String webIP;

  static {
    try {
      webIP = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      logger.error("获取日志Ip异常", e);
      webIP = null;
    }
  }

  @Override
  public String convert(ILoggingEvent event) {
    return webIP;
  }
}

package cn.lsr.common.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 日志工具类
 * @Author: lsr
 * @Date 2022年08月15日 18:08
 */
public class LogUtil {

    public static Logger getSysLog(Class<?> name){
        return LoggerFactory.getLogger("sys.boot"+name);
    }

    public static Logger getThreadPollLog(Class<?> name){
        return LoggerFactory.getLogger("sys.boot"+name);
    }

    public static Logger getDiscoveryLog(Class<?> name){
        return LoggerFactory.getLogger("sys.discovery"+name);
    }
}

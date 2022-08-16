package cn.lsr.boot.core.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Description: 日志工具类
 * @Author: lsr
 * @Date 2022年08月15日 18:08
 */
public class LogUtil {
    public static Logger getSysLog(Class<?> name){
        return LogManager.getLogger("sys.boot"+name);
    }
}

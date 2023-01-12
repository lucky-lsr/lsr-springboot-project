package cn.lsr.common.log;

import org.apache.logging.log4j.ThreadContext;

/**
 * @Description: 日志上下文工具类
 * @Author: lsr
 * @Date 2022年08E15日 15:02
 */
public class LogContextUtil {
    /**
     * 轮询线程
     * @param threadName
     */
    public static void setThreadPollContext(String threadName){
        ThreadContext.put("kind", threadName);
        ThreadContext.put("log_group", "poll");
        ThreadContext.put("log_type", "system");
    }

    public static void setBootStart(){
        ThreadContext.put("log_group", "boot");
        ThreadContext.put("log_type", "system");
    }
    public static void clear(){
        ThreadContext.clearAll();
    }
}

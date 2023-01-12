package cn.lsr.discovery.core.thread;

import cn.lsr.common.log.LogContextUtil;
import cn.lsr.common.log.LogUtil;
import org.slf4j.Logger;


/**
 * @Description: 服务心跳轮询线程
 * @Author: lsr
 * @Date 2022年08月16日 17:13
 */
public class ServiceInstanceDiscoveryThread extends AbstractPollThread {
    private static final Logger log = LogUtil.getThreadPollLog(ServiceInstanceDiscoveryThread.class);
    private String threadName;
    public ServiceInstanceDiscoveryThread(String threadName, Long delay, Long pollInterval) {
        super(threadName, delay, pollInterval);
        this.threadName = threadName;
    }

    @Override
    void process() {
        //TODO 设置log4j 上下文
        LogContextUtil.setThreadPollContext(this.threadName);
        log.info("thread poll .....");
    }
}

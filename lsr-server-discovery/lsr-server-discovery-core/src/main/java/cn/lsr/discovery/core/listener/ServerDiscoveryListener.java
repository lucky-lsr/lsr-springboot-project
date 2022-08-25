package cn.lsr.discovery.core.listener;

import cn.lsr.boot.core.event.ApplicationEventPublishType;
import cn.lsr.boot.core.event.ApplicationGlobalEvent;
import cn.lsr.boot.core.log.LogContextUtil;
import cn.lsr.boot.core.log.LogUtil;
import cn.lsr.discovery.core.config.ServerDiscoveryConfig;
import cn.lsr.discovery.core.thread.ServiceInstanceDiscoveryThread;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * @Description: 心跳服务监听器 ，通过自动装配心跳开关加载bean
 * TODO 后续可以根据自己需求，编写多个监听器，实现多服务心跳
 * @Author: lsr
 * @Date 2022年08月01日 20:08
 */
public class ServerDiscoveryListener implements ApplicationListener<ApplicationGlobalEvent>, Ordered {

    private static final Logger log = LogUtil.getSysLog(ServerDiscoveryListener.class);

    @Autowired
    ServerDiscoveryConfig serverDiscoveryConfig;

    ServiceInstanceDiscoveryThread serviceInstanceDiscoveryThread;

    @Override
    public void onApplicationEvent(ApplicationGlobalEvent status) {
        if (status.getSource() == ApplicationEventPublishType.STARTING) {
            //TODO 08/06 心跳注册开始，心跳服务是否强制开启，不同的服务心跳 注册不同的监听器来实现
            log.info("discovery server start ...");
            serviceInstanceDiscoveryThread = new ServiceInstanceDiscoveryThread("server-discovery",serverDiscoveryConfig.getDelay(),serverDiscoveryConfig.getPollInterval());
            serviceInstanceDiscoveryThread.start();
        } else if (status.getSource() == ApplicationEventPublishType.CLOSE) {
            //TODO 关闭心跳线程，也可以使用注册钩子回调
            //Runtime.getRuntime().addShutdownHook();
            serviceInstanceDiscoveryThread.shuntDown();
            log.info("discovery server shuntdown ...");
        }
    }

    @Override
    public int getOrder() {
        return 2;
    }
}

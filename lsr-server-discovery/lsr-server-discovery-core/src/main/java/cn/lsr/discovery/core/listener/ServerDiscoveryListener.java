package cn.lsr.discovery.core.listener;

import cn.lsr.boot.core.event.ApplicationEventPublishType;
import cn.lsr.boot.core.event.ApplicationGlobalEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * @Description: 心跳服务监听器 ，通过自动装配心跳开关加载bean
 * @Author: lsr
 * @Date 2022年08月01日 20:08
 */
public class ServerDiscoveryListener implements ApplicationListener<ApplicationGlobalEvent>, Ordered {

    @Override
    public void onApplicationEvent(ApplicationGlobalEvent status) {
        if (status.getSource() == ApplicationEventPublishType.STARTING) {
            //TODO 心跳注册开始
            System.out.println("discovery server start ...");
        }
    }

    @Override
    public int getOrder() {
        return 2;
    }
}

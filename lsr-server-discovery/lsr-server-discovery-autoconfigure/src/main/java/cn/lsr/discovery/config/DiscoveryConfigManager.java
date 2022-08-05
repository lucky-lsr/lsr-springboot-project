package cn.lsr.discovery.config;

import cn.lsr.discovery.core.config.ServerDiscoveryConfig;
import cn.lsr.discovery.core.listener.ServerDiscoveryListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Description: 心跳注册配置类
 * @Author: lsr
 * @Date 2022年08月04日 10:51
 */
@Configuration
@ConditionalOnProperty(prefix = "lsr.discovery", name = "enabled", matchIfMissing = false, havingValue = "true")
@Order(31)
public class DiscoveryConfigManager {

    @ConditionalOnMissingBean(ServerDiscoveryListener.class)
    @Bean
    public ServerDiscoveryListener initServerDiscoveryListener() {
        return new ServerDiscoveryListener();
    }

    @Bean
    public ServerDiscoveryConfig initServerDiscoveryConfig() {
        return new ServerDiscoveryConfig();
    }
}

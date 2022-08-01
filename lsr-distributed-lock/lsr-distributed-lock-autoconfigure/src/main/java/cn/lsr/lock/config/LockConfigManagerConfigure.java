package cn.lsr.lock.config;

import cn.lsr.lock.api.DistributeMutex;
import cn.lsr.lock.core.DBDistributeMutex;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * @Description: 分布式锁组件自动装配
 * @Author: lsr
 * @Date 2022年07月29日 10:30
 */
@Configuration
@ConditionalOnProperty(prefix = "lsr.lock",name = "enabled",matchIfMissing = false,havingValue = "true")
@Order(30)
public class LockConfigManagerConfigure {

    @Bean

    @ConditionalOnProperty(prefix = "lsr.lock",name = "type",havingValue = "db")
    public DistributeMutex initDistributeMutex(){
        return new DBDistributeMutex();
    }
}

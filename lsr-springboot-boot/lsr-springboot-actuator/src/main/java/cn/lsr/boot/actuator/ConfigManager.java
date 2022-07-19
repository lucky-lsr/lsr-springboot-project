package cn.lsr.boot.actuator;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @Description: 配置类
 * @Author: lsr
 * @Date 2022年07月18日 14:12
 */
@Configurable
public class ConfigManager {

    @Bean
    @ConditionalOnMissingBean //条件注解1：表示当前bean缺少的时候才会注入bean
    @ConditionalOnAvailableEndpoint //条件注解2：表示当监控端点被开启的时候，才会将自定义的类注入到程序应用中
    public CustomEndPoint initCustomEndPoint(){
        return new CustomEndPoint();
    }
}

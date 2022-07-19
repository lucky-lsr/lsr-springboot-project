package cn.lsr.boot.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 全局事件定义
 * @Author: lsr
 * @Date 2022年06月24日 12:15
 */
public class ApplicationGlobalEvent extends ApplicationEvent {
    public ApplicationGlobalEvent(ApplicationEventPublishType source) {
        super(source);
    }
}

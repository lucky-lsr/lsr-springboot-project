package cn.lsr.boot.core.listener;

import cn.lsr.boot.core.constant.ListenerOrder;
import cn.lsr.boot.core.event.ApplicationEventPublishType;
import cn.lsr.boot.core.event.ApplicationGlobalEvent;
import cn.lsr.boot.core.log.LogUtil;
import cn.lsr.boot.core.log.LogContextUtil;
import cn.lsr.boot.core.util.VersionUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description: 扩展全局listener
 * @see org.springframework.boot.context.event.EventPublishingRunListener
 * @Author: lsr
 * @Date 2022年06月24日 11:38
 */
public class ApplicationGlobalListener implements SpringApplicationRunListener, Ordered {
    private Logger log = LogUtil.getSysLog(ApplicationGlobalListener.class);
    /**
     * 构造函数不能省略
     * @param application
     * @param args
     */
    public ApplicationGlobalListener(SpringApplication application, String[] args){
        //设置日志启动上下文
        LogContextUtil.setBootStart();
        //方便查看 将springboot spring jdk 版本信息输出到控制台
        VersionUtil.printlnSpringBootAndSpringVersion();
        //jdk版本+机器信息
        VersionUtil.printlnJdkVersion();
    }
    /**
     * 在 run 方法第一次启动时立即调用。
     * 一般作用于启动参数校验
     * @param bootstrapContext
     */
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        try{

            log.info("****************** starting ******************");
        }catch ( Exception e){
            throw new RuntimeException("Service Startup Failure", e);
        }
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
                                         ConfigurableEnvironment environment) {
    }

    /**
     * 上下文已刷新，应用程序已启动但 CommandLineRunners尚未ApplicationRunners调用。
     * @see SpringApplicationRunListener
     * contextPrepared contextLoaded 都不能够发布事件
     * 所以将发布事件放在started最为合适
     * @param context
     */
    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("system status started");
        log.info("****************** started ******************");
        //TODO 此事件作为预留
        context.publishEvent(new ApplicationGlobalEvent(ApplicationEventPublishType.INIT));
        // 发布启动事件
        context.publishEvent(new ApplicationGlobalEvent(ApplicationEventPublishType.STARTING));

    }

    /**
     * 在 run 方法完成之前立即调用，此时应用程序上下文已刷新并且所有 CommandLineRunners 和 ApplicationRunners 已被调用。
     * @param context
     */
    @Override
    public void running(ConfigurableApplicationContext context){
        log.info("****************** running ******************");
        System.out.println("system status success");
    }
    /**
     * 当运行应用程序发生故障时调用。
     * @param context
     * @param exception
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        // 启动异常，发布关闭事件，清理释放资源
        context.publishEvent(new ApplicationGlobalEvent(ApplicationEventPublishType.CLOSE));
        log.error("****************** failed ******************",exception);
    }

    @Override
    public int getOrder() {
        // org.springframework.boot.context.event.EventPublishingRunListener  order 为0
        // order 为1  暂定我们执行时机可以靠后
        return ListenerOrder.GLOBAL_LISTENER_ORDER;
    }
}

package cn.lsr.boot.core.handler;

import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.stereotype.Component;

/**
 * @Description: 自定义异常码拦截异常处理
 * @see org.springframework.boot.SpringApplication
 * method getExitCodeFromMappedException 返回程序运行退出码 不为0时进行处理
 * 如listener 监听事件抛出异常，springboot不进行处理，不会停止当前进程导致应用卡死端口占用问题
 * @Author: lsr
 * @Date 2022年06月24日 12:21
 */
@Component
public class CustomExitCodeExceptionMapper implements ExitCodeExceptionMapper {
    @Override
    public int getExitCode(Throwable exception) {
        //所有异常都进行捕获
        return -1;
    }
}

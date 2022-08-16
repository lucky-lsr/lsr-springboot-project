package cn.lsr.boot;

import cn.lsr.boot.core.param.SystemParamManagerConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 启动类
 * @Author: lsr
 * @Date 2022年06月16日 15:20
 */
@SpringBootApplication(scanBasePackages = "cn.lsr.*")
public class Application {
    public static void main(String[] args) {
        System.setProperty(SystemParamManagerConstant.systemId, "boot-demo");
        System.setProperty(SystemParamManagerConstant.logHome, "logs");
        System.setProperty("log4j.configurationFile", "log4j2.xml");
        SpringApplication.run(Application.class, args);
    }
}

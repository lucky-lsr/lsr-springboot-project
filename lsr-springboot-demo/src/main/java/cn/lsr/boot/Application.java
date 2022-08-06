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
        System.setProperty(SystemParamManagerConstant.systemId, "test");
        SpringApplication.run(Application.class, args);
    }
}

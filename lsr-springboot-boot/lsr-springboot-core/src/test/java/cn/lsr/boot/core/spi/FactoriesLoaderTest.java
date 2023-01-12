package cn.lsr.boot.core.spi;

import cn.lsr.boot.core.param.SystemParamManagerConstant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年08月26日 10:08
 */
//@ActiveProfiles("test") // 读取指定配置文件
@SpringBootTest //获取启动类，加载配置，寻找主配置启动类（被 @SpringBootApplication 注解的）
public class FactoriesLoaderTest {

    @BeforeAll
    static void before(){
        System.setProperty(SystemParamManagerConstant.systemId, "boot-demo");
        System.setProperty(SystemParamManagerConstant.logHome, "logs");
    }

    @Test
    void getDefaultFactory() {
        TestServer testServer = FactoriesLoader.getDefaultFactory(TestServer.class);
        testServer.test();
    }

    @Test
    void getFactoryById() {
        TestServer testServer = FactoriesLoader.getFactoryById(TestServer.class,"test");
        testServer.test();
    }

    @Test
    void getAllFactories() {
        List<TestServer> allFactories = FactoriesLoader.getAllFactories(TestServer.class);
        for (TestServer allFactory : allFactories) {
            allFactory.test();
        }
    }

    @Test
    void getFactoriesByGroup() {

    }

    @Test
    void getOldestFactory(){
        TestServer oldestFactory = FactoriesLoader.getOldestFactory(TestServer.class);
        oldestFactory.test();
    }

}
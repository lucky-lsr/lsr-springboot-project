package cn.lsr.boot.core.util;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

/**
 * @Description: 版本工具类
 * @Author: lsr
 * @Date 2022年06月24日 11:41
 */
public class VersionUtil {
    public static void printlnSpringBootAndSpringVersion(){
        String springBootVersion = SpringBootVersion.getVersion();
        String springVersion = SpringVersion.getVersion();
        System.out.println("Running with Spring Boot v"+springVersion +", Spring "+ springBootVersion);
    }

    public static void printlnJdkVersion(){
        // 获取JDK的版本号
        // 获取jdk的详细版本号， 例如：1.8.0_91 ， 1.7.0_79，1.6.0
        String javaVersion = System.getProperty("java.version");
        // 获取JDK的位数
        // 64位JDK：amd64 ，32位JDK：x86
        String vm = System.getProperty("os.arch");
        System.out.println("Starting Application using Java v"+javaVersion+" on "+vm);

    }
}

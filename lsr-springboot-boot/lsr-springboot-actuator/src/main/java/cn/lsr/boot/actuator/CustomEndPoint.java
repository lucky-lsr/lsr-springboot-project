package cn.lsr.boot.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 自定义断点
 * @Author: lsr
 * @Date 2022年07月18日 14:13
 */
@Component
@Endpoint(id = "customEndPoint")//端点路径不要与系统自带的重合
public class CustomEndPoint {
    /**
     * 一般端点都是对象，或者一个json返回的格式，所以通常我们会将端点定义一个MAP的返回形式
     * 通过ReadOperation
     * 访问地址是根据前缀+ endpoint 的ID
     */
    private String name = "lsr";

    @ReadOperation //显示监控指标
    public Map info(){
        Map info = new HashMap();
        info.put("name","lsr");
        return info;
    }

    @WriteOperation //动态修改指标，是以post方式修改
    public void updateInfo(String newName){
        this.name = newName;
    }
}

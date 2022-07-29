package cn.lsr.boot.lock;

import cn.lsr.lock.api.DistributeMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年07月29日 15:06
 */
@RestController(value = "/lock")
public class TestDBLock {

    @Autowired
    DistributeMutex distributeMutex ;

    @GetMapping("/get")
    public void getLock(String name ,String group){
        distributeMutex.init(name,group);
    }

}

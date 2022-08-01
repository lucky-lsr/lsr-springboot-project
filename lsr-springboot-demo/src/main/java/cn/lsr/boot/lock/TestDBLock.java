package cn.lsr.boot.lock;

import cn.lsr.lock.api.DistributeMutex;
import cn.lsr.lock.core.entity.Mutex;
import cn.lsr.lock.core.mapper.MutexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年07月29日 15:06
 */
@RestController(value = "/lock")
public class TestDBLock {

    @Autowired
    DistributeMutex distributeMutex ;

    @Autowired
    MutexMapper mutexMapper;

    @GetMapping("/get")
    public void getLock(String name ,String group){

        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread t = new Thread(()->{
            try {
                distributeMutex.init(name,group);
                distributeMutex.transactionCodeBlock(()->{
                    try {
                        Thread.sleep(10000);
                        System.out.println(Thread.currentThread().getName()+"执行代码块。。。。");
                    }catch (Exception e){

                    }
                    return null;
                });
            }catch (Exception e){
                System.out.println("exception : "+e);
            }
        });
        for (int i = 0; i <5; i++) {
            executorService.execute(t);
        }
        executorService.shutdown();
    }
    @GetMapping("/get1")
    public void getLock1(String name ,String group){
        Mutex mutex = new Mutex(name,group);
        mutex.insert();
        //mutexMapper.selectWithLock(name,group);
        System.out.println("test ");
    }
    @GetMapping("/get2")
    public void getLock2(String name ,String group){
        Mutex mutex = new Mutex(name,group);
        mutexMapper.insert(mutex);
        //mutexMapper.selectWithLock(name,group);
        System.out.println("test ");
    }
}

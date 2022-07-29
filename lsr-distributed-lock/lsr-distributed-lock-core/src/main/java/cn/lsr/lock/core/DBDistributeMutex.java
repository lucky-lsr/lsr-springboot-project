package cn.lsr.lock.core;

import cn.lsr.lock.api.DistributeMutex;
import cn.lsr.lock.core.entity.Mutex;
import cn.lsr.lock.core.mapper.MutexMapper;

import javax.annotation.Resource;

/**
 * @Description: DB方式实现分布式锁
 * @Author: lsr
 * @Date 2022年07月29日 10:28
 */
public class DBDistributeMutex implements DistributeMutex {
    @Resource
    MutexMapper mutexMapper;

    private String name;
    private String group;

    @Override
    public void init(String name,String group) {
        this.name = name;
        this.group = group;
        Mutex mutex = new Mutex();
        mutex.setName(name);
        mutex.setGroup(group);
        try {
            mutex.insert();
        }catch (Exception e){
            //TODO 出错，可能其他线程已经插入数据，可以忽略
        }
    }

    @Override
    public void acquire() throws InterruptedException {
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
        int count = 0;
        Throwable initCause = null;
        do {
            count++;
            try {
                mutexMapper.selectWithLock(this.name,this.group);
            }catch (Exception e){
                //TODO 获取分布式锁失败，重试
                if (initCause == null){
                    initCause = e;
                }
            }
            // 等待1秒再重试
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }while (count<4);
        throw new RuntimeException("获取分布式锁失败，已达到最大重试次数："+count);
    }

    @Override
    public void release() {

    }

    @Override
    public boolean attempt(long msecs) {
        throw new RuntimeException("方法不可用！");
    }
}

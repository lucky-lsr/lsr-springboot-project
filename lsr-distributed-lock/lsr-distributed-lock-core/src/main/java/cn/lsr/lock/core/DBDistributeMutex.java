package cn.lsr.lock.core;

import cn.lsr.common.RunnableWithReturn;
import cn.lsr.lock.api.DistributeMutex;
import cn.lsr.lock.core.entity.Mutex;
import cn.lsr.lock.core.mapper.MutexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;



/**
 * @Description: DB方式实现分布式锁
 * @Author: lsr
 * @Date 2022年07月29日 10:28
 */
@EnableTransactionManagement
public class DBDistributeMutex<T> implements DistributeMutex<T> {

    @Autowired
    MutexMapper mutexMapper;

    @Autowired
    PlatformTransactionManager platformTransactionManager;

    /**
     * 事务状态对象
     * 线程变量存储，防止线程复用导致 status 出现混乱，需要手动 remove掉
     */
    private static ThreadLocal<TransactionStatus> status = new ThreadLocal<>();

    private String name;
    private String group;

    @Override
    public void init(String name,String group) {
        this.name = name;
        this.group = group;
        Mutex mutex = mutexMapper.selectOneByMutexNameAndMutexGroup(name, group);
        if (null == mutex){
            mutex = new Mutex(name,group);
            try {
                mutexMapper.insert(mutex);
            }catch (Exception e){
                //TODO 可能有其他线程已经插入
            }
        }
    }

    @Override
    public void acquire() throws InterruptedException {
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
        int count = 0;
        Throwable initCause = null;
        TransactionStatus transaction = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        status.set(transaction);
        do {
            count++;
            try {
                mutexMapper.selectWithLock(this.name,this.group);
                System.out.println(Thread.currentThread().getName()+"获取分布式成功。。"+status.get().toString());
                return;
            }catch (Exception e){
                System.out.println(Thread.currentThread().getName()+"获取分布式锁失败："+e);
                //TODO 获取分布式锁失败，重试
                if (initCause == null){
                    initCause = e;
                }
            }
            // 等待1秒再重试
            try {
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName()+"获取分布式锁失败，进行重试，重试次数为："+count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }while (count<4);
        throw new RuntimeException(Thread.currentThread().getName()+"获取分布式锁失败，已达到最大重试次数："+count);
    }

    @Override
    public void release() {
        platformTransactionManager.commit(status.get());
        System.out.println(Thread.currentThread().getName()+"释放分布式锁"+status.get().toString());
        status.remove();
    }

    @Override
    public boolean attempt(long msecs) {
        throw new RuntimeException("方法不可用！");
    }

    @Override
    public T transactionCodeBlock(RunnableWithReturn<T> runnableWithReturn){
        try {
            this.acquire();
            return runnableWithReturn.execute();
        }catch (Exception e){
            System.out.println("执行分布式锁方法块异常："+e);
        }finally {
            this.release();
        }
        return null;
    }
}

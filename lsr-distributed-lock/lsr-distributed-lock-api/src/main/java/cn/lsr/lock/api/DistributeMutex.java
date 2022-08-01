package cn.lsr.lock.api;

import cn.lsr.common.RunnableWithReturn;

/**
 * @Description: 分布式互斥锁
 * @Author: lsr
 * @Date 2022年07月29日 10:23
 */
public interface DistributeMutex<T> {
    /**
     * 初始化锁资源，若锁资源不存在，则创建
     * @param name 锁资源名称
     * @param group 锁资源分组
     */
    public void init(String name,String group);

    /**
     * 获取锁资源，资源不可用时一直等待，若被中断则抛出异常。
     *
     * @throws InterruptedException
     */
    public void acquire() throws InterruptedException;

    /**
     * 释放持有的锁资源。
     */
    public void release();

    /**
     * 在一段时间内尝试获取所资源。
     *
     * @param msecs 等待时间（毫秒）
     * @return 若在 msces 时间内无法获取锁资源则返回false，否则返回true。
     */
    public boolean attempt(long msecs);

    /**
     * 在分布式锁事务中执行方法块
     * @param runnableWithReturn 方法块
     */
    public T transactionCodeBlock(RunnableWithReturn<T> runnableWithReturn);
}

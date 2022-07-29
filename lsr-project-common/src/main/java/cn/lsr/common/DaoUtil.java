package cn.lsr.common;


import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 带事务的方法块
 * @Author: lsr
 * @Date 2022年07月29日 14:05
 */

public class DaoUtil {
    private static DaoUtil daoUtil = new DaoUtil();
    private static DaoUtil getInstance(){
        return daoUtil;
    }
    /**
     * 在新的事务中执行代码块
     * @param run
     * @param <R>
     * @return
     */
    @Transactional
    public <R> R executeInNewTransaction(RunnableWithReturn<R> run) {
        return run.execute();
    }

}

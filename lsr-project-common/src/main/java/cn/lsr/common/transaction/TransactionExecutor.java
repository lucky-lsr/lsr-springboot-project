package cn.lsr.common.transaction;

import cn.lsr.common.RunnableWithReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Description: 事务执行器
 * @Author: lsr
 * @Date 2022年12月26日 19:13
 */
@Component
public class TransactionExecutor {

    private Logger log = LoggerFactory.getLogger(TransactionExecutor.class);

    private static TransactionTemplate transactionTemplate;

    @Autowired
    public TransactionExecutor(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * 事物块执行
     *
     * @param runnableWithReturn 待执行代码块
     */
    public static void execute(RunnableWithReturn runnableWithReturn) {
        //不关心结果的事务执行方式
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                runnableWithReturn.execute();
            }
        });
    }
}

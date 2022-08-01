package cn.lsr.common;

/**
 * @Description: 代码块回调
 * @Author: lsr
 * @Date 2022年07月29日 11:05
 */
@FunctionalInterface
public interface RunnableWithReturn<R> {
     R execute();
}

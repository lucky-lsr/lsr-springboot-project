package cn.lsr.boot.abs;

/**
 * @Description: 抽象类
 * @Author: lsr
 * @Date 2022年07月21日 17:12
 */
public abstract class AbstractBatchDataProcess implements BatchDataProcess{
    @Override
    public void init(){
        System.out.println("我是抽象方法init ");
        initTow();
    }
    abstract void initTow();
}

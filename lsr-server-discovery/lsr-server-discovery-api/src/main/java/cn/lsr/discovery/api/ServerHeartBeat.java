package cn.lsr.discovery.api;

/**
 * @Description: 服务心跳接口
 * @Author: lsr
 * @Date 2022年08月01日 19:27
 */
public interface ServerHeartBeat {

    /**
     * 启动心跳方法
     */
    void start();

    /**
     * 更新心态哦方法
     */
    void heartBeat();

    /**
     * 停止心跳，回收资源
     */
    void stop();

}

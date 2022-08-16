package cn.lsr.discovery.core.config;

/**
 * @Description: 心跳服务配置类
 * @Author: lsr
 * @Date 2022年08月04日 10:52
 */
public class ServerDiscoveryConfig {

    private int threadPollSize;

    private int heartBeatInterval;

    private int delay;

    private int pollInterval;

    public int getThreadPollSize() {
        return threadPollSize;
    }

    public void setThreadPollSize(int threadPollSize) {
        this.threadPollSize = threadPollSize;
    }

    public int getHeartBeatInterval() {
        return heartBeatInterval;
    }

    public void setHeartBeatInterval(int heartBeatInterval) {
        this.heartBeatInterval = heartBeatInterval;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getPollInterval() {
        return pollInterval;
    }

    public void setPollInterval(int pollInterval) {
        this.pollInterval = pollInterval;
    }
}

package cn.lsr.discovery.core.config;

/**
 * @Description: 心跳服务配置类
 * @Author: lsr
 * @Date 2022年08月04日 10:52
 */
public class ServerDiscoveryConfig {

    private int threadPollSize;

    private int heartBeatInterval;

    private long delay;

    private long pollInterval;

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

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getPollInterval() {
        return pollInterval;
    }

    public void setPollInterval(long pollInterval) {
        this.pollInterval = pollInterval;
    }
}

package cn.lsr.protocol.api.remote;

import cn.lsr.common.entity.CommResponse;

/**
 * @Description: 服务调用统一入口
 * @Author: lsr
 * @Date 2022年07月27日 15:53
 */
public interface ServiceCall {
    /**
     * 远程外调入口
     * @param input 输入区数据
     * @return
     */
    CommResponse callRemote(Object input);
}

package cn.lsr.discovery.api;

/**
 * @Description: 服务实例信息
 * @Author: lsr
 * @param <T> 心跳对象
 * @Date 2022年08月01日 19:35
 */
public class ServerInstance {
    /**
     * Service名称
     */
    private String name;
    /**
     * NamedService ID, 格式为hostname#user#vmid
     */
    private String id;
    /**
     * NamedService所属的机器地址
     */
    private String address;

    /**
     * 提供对外服务的端口，内部使用的服务可以不填。
     */
    private Integer port;

}

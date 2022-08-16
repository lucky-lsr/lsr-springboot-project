package cn.lsr.discovery.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 服务实例心跳
 * @Author: lsr
 * @Date 2022年08月06日 20:01
 */
@TableName("sys_service_instance")
public class ServiceInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统标识号
     */
    private String systemId;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 服务地址
     */
    private String serviceAddress;

    /**
     * 服务端口
     */
    private int servicePort;

    /**
     * 初始更新时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date lastModifyTime;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(int servicePort) {
        this.servicePort = servicePort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}

package cn.lsr.discovery.api;

import cn.lsr.discovery.api.entity.ServiceInstance;

import java.util.Collection;
import java.util.List;

/**
 * @Description: 服务信息接口
 * @Author: lsr
 * @Date 2022年08月06日 21:54
 */
public interface ServiceInstanceService {
    /**
     * 根据服务名和系统编号获取实例列表
     *
     * @param serviceName
     * @param systemId
     * @return
     */
    List<ServiceInstance> selectInstanceListByServiceNameAndSystemId(String serviceName, String systemId);

    /**
     * 根据服务名和系统编号以及服务id获取实例
     *
     * @param serviceName
     * @param systemId
     * @param serviceId
     * @return
     */
    ServiceInstance selectInstanceByServiceNameAndSystemIdAndServiceId(String serviceName, String systemId, String serviceId);

    /**
     * 根据服务名和系统编号以及服务id删除实例列表
     *
     * @param serviceName
     * @param systemId
     * @param serviceId
     * @return
     */
    int deleteInstanceByServiceNameAndSystemIdAndServiceId(String serviceName, String systemId, String serviceId);

    /**
     * 新增
     *
     * @param serviceInstance
     * @return
     */
    int insertServiceInstance(ServiceInstance serviceInstance);


    /**
     * 更新
     *
     * @param serviceInstance
     */
    int updateServiceInstance(ServiceInstance serviceInstance);

    /**
     * 获取所有存活的实例
     *
     * @param heartBeatInterval
     * @return
     */
    Collection<ServiceInstance> queryForActiveInstances(Integer heartBeatInterval);

    /**
     * 判断当前服务是否正常存活
     *
     * @param serviceId
     * @param timeStamp
     * @param heartBeatInterval
     * @return
     */
    boolean isInstanceActive(String serviceId, Long timeStamp, Integer heartBeatInterval);
}

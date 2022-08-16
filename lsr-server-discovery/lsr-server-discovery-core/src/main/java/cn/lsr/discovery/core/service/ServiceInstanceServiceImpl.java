package cn.lsr.discovery.core.service;

import cn.lsr.boot.core.param.SystemParamManagerUtils;
import cn.lsr.discovery.api.ServiceInstanceService;
import cn.lsr.discovery.api.entity.ServiceInstance;
import cn.lsr.discovery.core.mapper.ServiceInstanceMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 服务信息接口实现
 * @Author: lsr
 * @Date 2022年08月06日 21:56
 */
@Service
public class ServiceInstanceServiceImpl implements ServiceInstanceService {

    @Autowired
    ServiceInstanceMapper serviceInstanceMapper;

    @Override
    public List<ServiceInstance> selectInstanceListByServiceNameAndSystemId(String serviceName, String systemId) {
        return serviceInstanceMapper.selectList(Wrappers.<ServiceInstance>lambdaQuery()
                .eq(ServiceInstance::getSystemId, systemId)
                .eq(ServiceInstance::getServiceName, serviceName));
    }

    @Override
    public ServiceInstance selectInstanceByServiceNameAndSystemIdAndServiceId(String serviceName, String systemId, String serviceId) {
        return serviceInstanceMapper.selectOne(Wrappers.<ServiceInstance>lambdaQuery()
                .eq(ServiceInstance::getServiceName, serviceName)
                .eq(ServiceInstance::getSystemId, serviceId)
                .eq(ServiceInstance::getServiceId, serviceId));
    }

    @Override
    public int deleteInstanceByServiceNameAndSystemIdAndServiceId(String serviceName, String systemId, String serviceId) {
        return serviceInstanceMapper.delete(Wrappers.<ServiceInstance>lambdaQuery()
                .eq(ServiceInstance::getServiceName, serviceName)
                .eq(ServiceInstance::getSystemId, systemId)
                .eq(ServiceInstance::getServiceId, serviceId));
    }

    @Override
    public int insertServiceInstance(ServiceInstance serviceInstance) {
        return serviceInstanceMapper.insert(serviceInstance);
    }

    @Override
    public int updateServiceInstance(ServiceInstance serviceInstance) {
        return serviceInstanceMapper.update(serviceInstance, Wrappers.<ServiceInstance>lambdaUpdate()
                .eq(ServiceInstance::getServiceName, serviceInstance.getServiceName())
                .eq(ServiceInstance::getServiceId, serviceInstance.getServiceId())
                .eq(ServiceInstance::getSystemId, serviceInstance.getSystemId()));
    }

    @Override
    public Collection<ServiceInstance> queryForActiveInstances(Integer heartBeatInterval) {
        final Set<ServiceInstance> ret = new HashSet<>();
        List<ServiceInstance> items = selectInstanceListByServiceNameAndSystemId(
                SystemParamManagerUtils.getApplicationName(), SystemParamManagerUtils.getSystemId());
        if (items != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (ServiceInstance item : items) {
                if (isActive(currentTimeMillis, item.getLastModifyTime().getTime(), heartBeatInterval)) {
                    ret.add(item);
                }
            }
        }
        return ret;
    }

    @Override
    public boolean isInstanceActive(String serviceId, Long timeStamp, Integer heartBeatInterval) {
        ServiceInstance instance = selectInstanceByServiceNameAndSystemIdAndServiceId(
                SystemParamManagerUtils.getApplicationName(), SystemParamManagerUtils.getSystemId(), serviceId);

        // 1、instance == null 正常停机删除了心跳
        if (instance == null) {
            return false;
        }

        // 2、存在重启的情况
        if (instance.getCreateTime().getTime() >= timeStamp) {
            return false;
        }

        long currentTimeMillis = System.currentTimeMillis();
        // 3、心跳未正常更新，可能宕机
        if (!isActive(currentTimeMillis, instance.getLastModifyTime().getTime(), heartBeatInterval)) {
            return false;
        }

        return true;
    }

    /**
     * 判断最后一次心跳小于当前时间戳3个心跳则认为是不存活
     *
     * @param currentTimeMillis
     * @param lastHeartBeat
     * @param heartBeatInterval 心跳时间
     * @return
     */
    private boolean isActive(long currentTimeMillis, long lastHeartBeat, Integer heartBeatInterval) {
        return currentTimeMillis - lastHeartBeat <= (long) (3 * heartBeatInterval * 1000);
    }
}

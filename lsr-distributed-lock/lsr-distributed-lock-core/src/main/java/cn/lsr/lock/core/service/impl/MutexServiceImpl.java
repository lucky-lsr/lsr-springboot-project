package cn.lsr.lock.core.service.impl;

import cn.lsr.lock.core.entity.Mutex;
import cn.lsr.lock.core.mapper.MutexMapper;
import cn.lsr.lock.core.service.MutexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年07月29日 14:50
 */
@Service
public class MutexServiceImpl implements MutexService {
    @Resource
    MutexMapper mutexMapper;

    @Override
    public List<Mutex> selectWithLock(String name, String group) {
        return mutexMapper.selectWithLock(name,group);
    }
}

package cn.lsr.lock.core.service;

import cn.lsr.lock.core.entity.Mutex;

import java.util.List;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年07月29日 14:50
 */
public interface MutexService {
    List<Mutex> selectWithLock(String name, String group);
}

package cn.lsr.lock.core.mapper;

import cn.lsr.lock.core.entity.Mutex;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: 分布式锁mapper
 * @Author: lsr
 * @Date 2022年07月29日 14:45
 */
public interface MutexMapper extends BaseMapper<Mutex> {
    @Select("select * from sys_mutex where name = #{name} and group = #{group} for update ")
    List<Mutex> selectWithLock(String name, String group);
}

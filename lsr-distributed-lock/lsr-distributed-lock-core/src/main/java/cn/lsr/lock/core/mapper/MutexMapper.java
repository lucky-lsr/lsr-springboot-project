package cn.lsr.lock.core.mapper;

import cn.lsr.lock.core.entity.Mutex;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @Description: 分布式锁mapper
 * @Author: lsr
 * @Date 2022年07月29日 14:45
 */
public interface MutexMapper extends BaseMapper<Mutex> {

    @Select("select * from sys_mutex where mutex_name = #{mutex_name} and mutex_group = #{mutex_group} for update ")
    Mutex selectWithLock(@Param("mutex_name") String name, @Param("mutex_group") String group);

    @Select("select * from sys_mutex where mutex_name = #{mutex_name} and mutex_group = #{mutex_group}")
    Mutex selectOneByMutexNameAndMutexGroup(@Param("mutex_name") String name, @Param("mutex_group") String group);
}

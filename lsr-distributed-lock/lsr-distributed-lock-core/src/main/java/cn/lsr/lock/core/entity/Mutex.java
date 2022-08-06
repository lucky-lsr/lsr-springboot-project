package cn.lsr.lock.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @Description: 互斥锁对象
 * @Author: lsr
 * @Date 2022年07月29日 10:45
 */
@TableName("sys_mutex")
public class Mutex extends Model<Mutex> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String systemId;
    private String mutexName;
    private String mutexGroup;


    public Mutex(@Param("system_id") String systemId ,@Param("mutex_name") String mutexName, @Param("mutex_group")String mutexGroup) {
        this.systemId = systemId;
        this.mutexName = mutexName;
        this.mutexGroup = mutexGroup;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getMutexName() {
        return mutexName;
    }

    public void setMutexName(String mutexName) {
        this.mutexName = mutexName;
    }

    public String getMutexGroup() {
        return mutexGroup;
    }

    public void setMutexGroup(String mutexGroup) {
        this.mutexGroup = mutexGroup;
    }
}

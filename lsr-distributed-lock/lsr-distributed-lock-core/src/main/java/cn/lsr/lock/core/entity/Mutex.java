package cn.lsr.lock.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @Description: 互斥锁对象
 * @Author: lsr
 * @Date 2022年07月29日 10:45
 */
@TableName("sys_mutex")
public class Mutex extends Model<Mutex> {

    private String name;
    private String group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

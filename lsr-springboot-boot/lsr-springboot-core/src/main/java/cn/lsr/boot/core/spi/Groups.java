package cn.lsr.boot.core.spi;

import java.lang.annotation.*;

/**
 * @Description: spi实现支持分组方式
 * @Author: lsr
 * @Date 2022年08月26日 09:56
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Groups {

    /**
     * Group list
     *
     * @return
     */
    String[] value() default {};
}

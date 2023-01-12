package cn.lsr.boot.core.spi;

import java.lang.annotation.*;

/**
 * @Description: spi实现标记
 * @Author: lsr
 * @Date 2022年08月26日 09:51
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface SPIMeta {

    /**
     * Extension Implementation ID
     *
     * @return
     */
    String id() default "";
}

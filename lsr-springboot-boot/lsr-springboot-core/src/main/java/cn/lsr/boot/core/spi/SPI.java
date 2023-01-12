package cn.lsr.boot.core.spi;

import java.lang.annotation.*;

/**
 * @Description: 标记spi接口
 * @Author: lsr
 * @Date 2022年08月26日 09:47
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface SPI {
    /**
     * Default Implementation ID
     *
     * @return
     */
    String defaultId() default "";
}

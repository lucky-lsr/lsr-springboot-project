package cn.lsr.boot.core.spi;

import org.springframework.core.annotation.Order;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年08月26日 10:43
 */
@SPIMeta(id = "test")
@Order(-1)
public class TestServerImpl1 implements TestServer{
    @Override
    public void test() {
        System.out.println("我是test实现。。。");
    }
}

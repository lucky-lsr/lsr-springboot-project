package cn.lsr.boot.core.spi;

import org.springframework.core.annotation.Order;

/**
 * @Description:
 * @Author: lsr
 * @Date 2022年08月26日 10:43
 */
@SPIMeta(id = "default")
@Order(2)
public class TestServerImpl implements TestServer{
    @Override
    public void test() {
        System.out.println("我是default实现。。。");
    }
}

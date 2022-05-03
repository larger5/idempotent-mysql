package com.example.idempotentmysql.service;


import com.example.idempotentmysql.bean.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void placeOrderTest() {
        orderService.placeOrder(4L, 2L);
    }

    @Test
    public void cancelOrderTest() {
        orderService.cancelOrder(6L);
        orderService.cancelOrder(6L);
        orderService.cancelOrder(6L);
    }
}

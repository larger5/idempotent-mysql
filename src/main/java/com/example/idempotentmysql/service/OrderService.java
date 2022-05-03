package com.example.idempotentmysql.service;

import com.example.idempotentmysql.bean.OrderInfo;

/**
 * 订单取消服务
 *
 * @author hongcunlin
 */
public interface OrderService {
    /**
     * 下单
     *
     * @param userId    用户id
     * @param productId 商品id
     */
    void placeOrder(Long userId, Long productId);

    /**
     * 取消订单
     *
     * @param orderId 订单id
     */
    void cancelOrder(Long orderId);
}

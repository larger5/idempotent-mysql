package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单repository
 *
 * @author hongcunlin
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
}

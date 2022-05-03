package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品repository
 *
 * @author hongcunlin
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
}

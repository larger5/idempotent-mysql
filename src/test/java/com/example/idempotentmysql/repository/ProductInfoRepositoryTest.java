package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class ProductInfoRepositoryTest {
    /**
     * 用户repository
     */
    @Resource
    private ProductInfoRepository productInfoRepository;

    /**
     * 测试商品
     */
    @Test
    void contextLoads() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setPrice(new BigDecimal("5"));
        productInfo.setName("佳达隆茶轴");
        productInfoRepository.save(productInfo);
    }
}

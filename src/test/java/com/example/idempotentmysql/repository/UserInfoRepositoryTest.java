package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class UserInfoRepositoryTest {
    /**
     * 用户repository
     */
    @Resource
    private UserInfoRepository repository;

    /**
     * 测试用户
     */
    @Test
    void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setMoney(new BigDecimal("199900.01"));
        userInfo.setName("张三");
        repository.save(userInfo);
    }
}

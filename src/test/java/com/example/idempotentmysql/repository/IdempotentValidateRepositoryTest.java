package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.IdempotentValidate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class IdempotentValidateRepositoryTest {
    /**
     * 幂等性repository
     */
    @Resource
    private IdempotentValidateRepository idempotentValidateRepository;

    @Test
    public void test() {
        IdempotentValidate idempotentValidate = new IdempotentValidate();
        idempotentValidate.setOrderId(123L);
        idempotentValidateRepository.save(idempotentValidate);
    }
}

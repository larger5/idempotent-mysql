package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.IdempotentValidate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 幂等性repository
 *
 * @author hongcunlin
 */
public interface IdempotentValidateRepository extends JpaRepository<IdempotentValidate, Long> {
}

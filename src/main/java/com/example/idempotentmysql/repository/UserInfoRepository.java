package com.example.idempotentmysql.repository;

import com.example.idempotentmysql.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户repository
 *
 * @author hongcunlin
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}

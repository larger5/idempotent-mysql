package com.example.idempotentmysql.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息
 *
 * @author hongcunlin
 */
@Entity
@Data
@Table
public class UserInfo {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户余额
     */
    private BigDecimal money;

    /**
     * 创建时间
     */
    private Date createTime = new Date();
}

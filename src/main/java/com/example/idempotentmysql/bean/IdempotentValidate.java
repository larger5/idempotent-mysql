package com.example.idempotentmysql.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 幂等性校验
 *
 * @author hongcunlin
 */
@Entity
@Data
@Table
public class IdempotentValidate {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 订单Id
     * 唯一索引，幂等校验依据
     */
    @Column(unique = true)
    private Long orderId;

    /**
     * 创建时间
     */
    private Date createTime = new Date();
}

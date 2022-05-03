package com.example.idempotentmysql.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息
 *
 * @author hongcunlin
 */
@Entity
@Data
@Table
public class OrderInfo {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 创建时间
     */
    private Date createTime = new Date();
}

package com.example.idempotentmysql.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息
 *
 * @author hongcunlin
 */
@Entity
@Data
@Table
public class ProductInfo {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private Date createTime = new Date();
}

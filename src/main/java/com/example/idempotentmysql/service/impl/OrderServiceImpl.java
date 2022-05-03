package com.example.idempotentmysql.service.impl;

import com.example.idempotentmysql.bean.IdempotentValidate;
import com.example.idempotentmysql.bean.OrderInfo;
import com.example.idempotentmysql.bean.ProductInfo;
import com.example.idempotentmysql.bean.UserInfo;
import com.example.idempotentmysql.repository.IdempotentValidateRepository;
import com.example.idempotentmysql.repository.OrderInfoRepository;
import com.example.idempotentmysql.repository.ProductInfoRepository;
import com.example.idempotentmysql.repository.UserInfoRepository;
import com.example.idempotentmysql.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 订单服务
 *
 * @author hongcunlin
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);


    /**
     * 用户repository
     */
    @Resource
    private UserInfoRepository userInfoRepository;

    /**
     * 商品repository
     */
    @Resource
    private ProductInfoRepository productInfoRepository;

    /**
     * 订单repository
     */
    @Resource
    private OrderInfoRepository orderInfoRepository;

    /**
     * 幂等性校验
     */
    @Resource
    private IdempotentValidateRepository idempotentValidateRepository;

    /**
     * 取消订单（带幂等性校验）
     *
     * @param orderId 订单id
     */
    @Override
    public void cancelOrder(Long orderId) {
        // 1.幂等性校验
        try {
            IdempotentValidate idempotentValidate = new IdempotentValidate();
            idempotentValidate.setOrderId(orderId);
            idempotentValidateRepository.save(idempotentValidate);
        } catch (Exception e) {
            LOGGER.info("订单退款幂等");
            return;
        }

        // 2.退款
        Optional<OrderInfo> orderInfoOptional = orderInfoRepository.findById(orderId);
        if (orderInfoOptional.isPresent()) {
            OrderInfo orderInfo = orderInfoOptional.get();
            Optional<UserInfo> userInfoOptional = userInfoRepository.findById(orderInfo.getUserId());
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(orderInfo.getProductId());
            if (userInfoOptional.isPresent() && productInfoOptional.isPresent()) {
                UserInfo userInfo = userInfoOptional.get();
                ProductInfo productInfo = productInfoOptional.get();
                userInfo.setMoney(userInfo.getMoney().add(productInfo.getPrice()));
                userInfoRepository.save(userInfo);
            }
        }
        LOGGER.info("订单成功退款");
    }

    /**
     * 下单
     *
     * @param userId    用户id
     * @param productId 商品id
     */
    @Override
    public void placeOrder(Long userId, Long productId) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productId);
        if (userInfoOptional.isPresent() && productInfoOptional.isPresent()) {
            UserInfo userInfo = userInfoOptional.get();
            ProductInfo productInfo = productInfoOptional.get();
            userInfo.setMoney(userInfo.getMoney().subtract(productInfo.getPrice()));
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setUserId(userId);
            orderInfo.setProductId(productId);
            // 额度扣减
            userInfoRepository.save(userInfo);
            // 生成订单
            orderInfoRepository.save(orderInfo);
        }
    }
}

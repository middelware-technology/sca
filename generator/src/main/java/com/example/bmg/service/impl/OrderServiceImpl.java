package com.example.bmg.service.impl;

import com.example.bmg.entity.Order;
import com.example.bmg.mapper.OrderMapper;
import com.example.bmg.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}

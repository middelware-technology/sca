package com.example.bmg.service.impl;

import com.example.bmg.entity.OrderItem;
import com.example.bmg.mapper.OrderItemMapper;
import com.example.bmg.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}

package com.example.bmg.service.impl;

import com.example.bmg.entity.ShoppingCartItem;
import com.example.bmg.mapper.ShoppingCartItemMapper;
import com.example.bmg.service.IShoppingCartItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Service
public class ShoppingCartItemServiceImpl extends ServiceImpl<ShoppingCartItemMapper, ShoppingCartItem> implements IShoppingCartItemService {

}

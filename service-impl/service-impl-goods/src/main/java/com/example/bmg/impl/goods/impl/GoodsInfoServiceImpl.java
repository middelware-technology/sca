package com.example.bmg.impl.goods.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.beans.goods.GoodsInfo;
import com.example.bmg.api.goods.service.IGoodsInfoService;
import com.example.bmg.impl.goods.mapper.GoodsInfoMapper;
import com.example.bmg.utils.PageUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品详情表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@RestController
@Tag(name = "商品详情表 Service")
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements IGoodsInfoService {

    @Override
    public List<GoodsInfo> getGoodsList() {
        return List.of();
    }

    @Override
    public PageUtils<GoodsInfo> getGoodsPage(GoodsInfo goodsInfo) {
        return null;
    }

    @Override
    public GoodsInfo getGoodsById(Long goodsId) {
        return null;
    }
}

package com.example.bmg.impl.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.beans.goods.GoodsCategory;
import com.example.bmg.api.goods.service.IGoodsCategoryService;
import com.example.bmg.impl.goods.mapper.GoodsCategoryMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品类别表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@RestController
@Tag(name = "商品类别表 Service")
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService {

    @Resource
    GoodsCategoryMapper mapper;

    @Override
    public List<GoodsCategory> getGoodsCategoryList() {
        return mapper.selectList(new QueryWrapper<GoodsCategory>().eq("category_level", 1));
    }

    @Override
    public List<GoodsCategory> getGoodsCategoryListByParentId(Long parentId) {
        return List.of();
    }
}

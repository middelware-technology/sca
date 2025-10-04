package com.example.bmg.impl.ads.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bmg.ads.mapper.BmgCarouselMapper;
import com.example.bmg.api.ads.service.IBmgCarouselService;
import com.example.bmg.entity.BmgCarousel;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 轮播图表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-04
 */
@RestController
public class BmgCarouselServiceImpl extends ServiceImpl<BmgCarouselMapper, BmgCarousel> implements IBmgCarouselService {


    @Resource
    BmgCarouselMapper bmgCarouselMapper;

    @Override
    public List<BmgCarousel> getCarouselList() {
        return bmgCarouselMapper.selectList(new QueryWrapper<BmgCarousel>().eq("is_deleted", 0));
    }
}

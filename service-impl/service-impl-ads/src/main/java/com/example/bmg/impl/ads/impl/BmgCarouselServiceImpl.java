package com.example.bmg.impl.ads.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bmg.api.ads.service.IBmgCarouselService;
import com.example.bmg.entity.BmgCarousel;
import com.example.bmg.impl.ads.mapper.BmgCarouselMapper;
import com.example.bmg.utils.DataResults;
import com.example.bmg.utils.PageUtils;
import com.example.bmg.utils.ResultCode;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("ads")
public class BmgCarouselServiceImpl extends ServiceImpl<BmgCarouselMapper, BmgCarousel> implements IBmgCarouselService {


    @Resource
    BmgCarouselMapper bmgCarouselMapper;

    @Override
    public DataResults<List<BmgCarousel>>  getCarouselList() {

        return DataResults.success(ResultCode.CART_200,bmgCarouselMapper.selectList(new QueryWrapper<BmgCarousel>().eq("is_deleted", 0))) ;
    }

    @Override
    public DataResults<PageUtils<BmgCarousel>> page(BmgCarousel bmgCarousel) {
        QueryWrapper<BmgCarousel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", 0);
        Page<BmgCarousel> bmgCarouselPage = bmgCarouselMapper.selectPage(new Page<>(bmgCarousel.getPage(), bmgCarousel.getLimit()), queryWrapper);
        PageUtils<BmgCarousel> pageUtils = new PageUtils<>(
                bmgCarousel.getPage(), bmgCarousel.getLimit(),  bmgCarouselPage.getPages(),bmgCarouselPage.getTotal()
                ,bmgCarouselPage.getRecords());
        return DataResults.success(pageUtils);
    }

    @Override
    public DataResults<Integer> insert(BmgCarousel bmgCarousel) {
        return DataResults.success(ResultCode.SUCCESS,bmgCarouselMapper.insert(bmgCarousel));
    }

    @Override
    public DataResults<Integer>  update(BmgCarousel bmgCarousel) {
        return DataResults.success(ResultCode.SUCCESS,bmgCarouselMapper.updateById(bmgCarousel));
    }

    public DataResults<Integer>  delete(BmgCarousel bmgCarousel) {
        return DataResults.success(ResultCode.SUCCESS,bmgCarouselMapper.updateById(bmgCarousel));
    }

    @Override
    public DataResults<BmgCarousel> getById(Integer id) {
        return DataResults.success(ResultCode.SUCCESS,bmgCarouselMapper.selectById(id));
    }
}

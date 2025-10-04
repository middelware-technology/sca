package com.example.bmg.api.ads.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bmg.entity.BmgCarousel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 轮播图表 服务类
 * </p>
 *
 * @author CW
 * @since 2025-10-04
 */

@RequestMapping("ads")
public interface IBmgCarouselService  {


    @GetMapping("/list")
    List<BmgCarousel> getCarouselList();
}

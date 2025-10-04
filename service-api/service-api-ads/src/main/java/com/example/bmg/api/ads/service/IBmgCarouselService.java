package com.example.bmg.api.ads.service;

import com.example.bmg.entity.BmgCarousel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "轮播图服务",description = "轮播图相关API操作")
@RequestMapping("ads")
public interface IBmgCarouselService  {

    @Operation(summary = "查询所有轮播图")
    @ApiResponse(responseCode = "200", description = "轮播图列表")
    @GetMapping("/getCarouselList")
    List<BmgCarousel> getCarouselList();
}

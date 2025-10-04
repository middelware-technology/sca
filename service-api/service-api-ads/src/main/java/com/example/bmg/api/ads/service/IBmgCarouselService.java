package com.example.bmg.api.ads.service;

import com.example.bmg.entity.BmgCarousel;
import com.example.bmg.utils.DataResults;
import com.example.bmg.utils.PageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getCarouselList")
    DataResults<List<BmgCarousel>>  getCarouselList();

    @Operation(summary = "分页查询轮播图")
    @PostMapping("/page")
    DataResults<PageUtils<BmgCarousel>>  page(@RequestBody BmgCarousel bmgCarousel);

    @Operation(summary = "新增轮播图")
    @PostMapping("insert")
    DataResults<Integer> insert(@RequestBody BmgCarousel bmgCarousel);

    @Operation(summary = "更新轮播图")
    @PostMapping("update")
    DataResults<Integer> update(@RequestBody BmgCarousel bmgCarousel);

    @Operation(summary = "删除轮播图")
    @PostMapping("delete")
    DataResults<Integer> delete(@RequestBody BmgCarousel bmgCarousel);

    @Operation(summary = "根据Id查询轮播图信息")
    @GetMapping("{id}")
    DataResults<BmgCarousel> getById(@PathVariable("id") Integer id);

}

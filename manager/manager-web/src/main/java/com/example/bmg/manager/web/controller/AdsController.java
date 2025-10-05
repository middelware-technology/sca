package com.example.bmg.manager.web.controller;


import com.example.bmg.entity.BmgCarousel;
import com.example.bmg.manager.web.cache.CacheData;
import com.example.bmg.manager.web.client.AdsClient;
import com.example.bmg.utils.DataResults;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Tag(name = "轮播图 Controller")
@RestController
@RequestMapping("ads")
public class AdsController {

   @Resource
   CacheData cacheData;


    @Operation(summary = "查询轮播图")
    @ApiResponse(responseCode = "200", description = "轮播图列表")
    @GetMapping("getCarouselList/{id}")
    public DataResults<BmgCarousel>  getCarouselList(@PathVariable(name = "id") Integer id){

        log.info("进入getCarouselList视图");
        cacheData.getCarouselList(); // 远程获取广告列表

        return cacheData.getById(id);

    }
}

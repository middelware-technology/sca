package com.example.bmg.manager.web.cache;


import com.example.bmg.entity.BmgCarousel;
import com.example.bmg.manager.web.client.AdsClient;
import com.example.bmg.utils.DataResults;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Component
@CacheConfig(cacheNames = "ads")
public class CacheData {

    @Resource
    AdsClient adsClient;
    

    @Cacheable(key = "#root.methodName")
    public List<BmgCarousel> getCarouselList() {
        log.info("从数据库中获取轮播图数据 - 缓存未命中");
        List<BmgCarousel> result = adsClient.getCarouselList();
        log.info("获取到 {} 条轮播图数据", result != null ? result.size() : 0);
        return result;
    }

    @Cacheable(key = "#root.methodName+'_'+#id")
    public DataResults<BmgCarousel> getById(Integer id){
        log.info("从数据库中根据ID={},获取轮播图数据 - 缓存未命中",id);
        DataResults<BmgCarousel> result = adsClient.getById(id);
        log.info("获取到轮播图数据:{}",result);
        return result;
    }
}

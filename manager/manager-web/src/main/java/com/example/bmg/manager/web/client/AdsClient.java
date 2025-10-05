package com.example.bmg.manager.web.client;


import com.example.bmg.api.ads.service.IBmgCarouselService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(
        value = "ads-service"  // 远程服务名称
        ,path = "ads"          // 远程服务的基础路径
)
public interface AdsClient extends IBmgCarouselService {

}

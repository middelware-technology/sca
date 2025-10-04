package com.example.bmg.manager.web.client;


import com.example.bmg.api.ads.service.IBmgCarouselService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "ads-service",path = "ads")
public interface AdsClient extends IBmgCarouselService {

}

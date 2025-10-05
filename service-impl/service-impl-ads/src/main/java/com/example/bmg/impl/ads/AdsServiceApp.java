package com.example.bmg.impl.ads;


import com.example.bmg.entity.BmgCarousel;
import com.example.bmg.impl.ads.impl.BmgCarouselServiceImpl;
import com.example.bmg.utils.DataResults;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
//mybatis mapper接口类 扫描
@MapperScan("com.example.bmg.impl.ads.mapper")
@EnableDiscoveryClient
public class AdsServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(AdsServiceApp.class, args);
    }
}

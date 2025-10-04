package com.example.bmg;


import com.example.bmg.ads.impl.BmgCarouselServiceImpl;
import com.example.bmg.entity.BmgCarousel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
//mybatis mapper接口类 扫描
@MapperScan("com.example.bmg.api.ads.mapper")
public class AdsServiceApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AdsServiceApp.class, args);
        BmgCarouselServiceImpl bean = run.getBean(BmgCarouselServiceImpl.class);
        List<BmgCarousel> carouselList = bean.getCarouselList();
        System.out.println(carouselList.toString());
    }
}

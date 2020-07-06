package com.galaxy.crawler;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = {"com.galaxy.crawler.repo.mapper"})
@SpringBootApplication
@EnableScheduling
public class GalaxyCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalaxyCrawlerApplication.class, args);
    }

}

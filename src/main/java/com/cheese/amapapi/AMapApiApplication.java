package com.cheese.amapapi;

import com.cheese.amapapi.conf.AMapAPIConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(AMapAPIConf.class)
public class AMapApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AMapApiApplication.class, args);
    }
}

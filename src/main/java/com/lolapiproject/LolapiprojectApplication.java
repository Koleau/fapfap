package com.lolapiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class LolapiprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LolapiprojectApplication.class, args);
    }
}

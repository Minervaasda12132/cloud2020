package com.zzs.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.zzs.springcloud.dao")
@EnableEurekaClient
public class Payment8001_App {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001_App.class, args);
    }
}

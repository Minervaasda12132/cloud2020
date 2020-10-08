package com.zzs.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zzs.springcloud.dao")
public class PaymentMain9001_App {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001_App.class, args);
    }
}

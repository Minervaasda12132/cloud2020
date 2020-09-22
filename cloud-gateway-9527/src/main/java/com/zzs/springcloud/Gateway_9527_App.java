package com.zzs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Gateway_9527_App {
    public static void main(String[] args) {
        SpringApplication.run(Gateway_9527_App.class, args);
    }
}

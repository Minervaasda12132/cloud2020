package com.zzs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel_8763Main {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel_8763Main.class, args);
    }
}

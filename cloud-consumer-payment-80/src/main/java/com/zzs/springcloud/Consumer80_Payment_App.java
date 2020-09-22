package com.zzs.springcloud;

import com.zzs.myrule.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = RuleConfig.class)
public class Consumer80_Payment_App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80_Payment_App.class, args);
    }
}

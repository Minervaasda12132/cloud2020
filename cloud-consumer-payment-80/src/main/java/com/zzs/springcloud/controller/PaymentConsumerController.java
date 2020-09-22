package com.zzs.springcloud.controller;

import com.zzs.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class PaymentConsumerController {
    private final String HTTP_URL="http://CLOUD-PAYMENT-SERVICE/payment/get/";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id")Long id){

        return restTemplate.getForObject(HTTP_URL+id,CommonResult.class);
    }

    @GetMapping("/get/discovery")
    public Object getdiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("payment8001");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}

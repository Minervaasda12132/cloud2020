package com.zzs.springcloud.service;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-server",fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> echo(@PathVariable("id") Long id);

}

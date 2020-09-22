package com.zzs.springcloud.controller;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")Long id){

        log.info("==========Order jinlia le ");
        return orderService.getPaymentById(id);
    }



}

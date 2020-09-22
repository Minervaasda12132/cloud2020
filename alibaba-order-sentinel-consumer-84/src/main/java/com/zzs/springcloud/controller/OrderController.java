package com.zzs.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.handle.OrderHandle;
import com.zzs.springcloud.service.OrderFallBack;
import com.zzs.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/getOrder/{id}")
  @SentinelResource(value = "getOrder",blockHandlerClass = OrderHandle.class,blockHandler = "getOrderHandle")
 /*   @SentinelResource(value = "getOrder",
            blockHandler = "getOrderHandle",
            blockHandlerClass = {OrderHandle.class},
            fallback = "getOrderFallback",
            fallbackClass = {OrderFallBack.class})*/
    public CommonResult<Payment> getPaymentInfo(@PathVariable("id") int id) {
        log.info("================" + id);

        return orderService.echo(1L);
    }


}

package com.zzs.springcloud.controller;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    protected PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment pay = paymentService.selectId(id);
        log.info("==========查询数据" + pay);
        if (pay != null) {
            return CommonResult.create(200, "成功",pay);
        } else {
            return CommonResult.create(444, "查询失败id ："+id);
        }

    }
    @GetMapping("/payment/lb")
    public String serverPort(){
        return serverPort;
    }
}

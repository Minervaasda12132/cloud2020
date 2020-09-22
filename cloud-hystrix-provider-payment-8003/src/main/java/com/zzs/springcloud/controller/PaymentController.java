package com.zzs.springcloud.controller;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    protected PaymentService paymentService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment pay = paymentService.selectId(id);
        log.info("==========查询数据" + pay);
        if (pay != null) {
            return CommonResult.create(200, "成功",pay);
        } else {
            return CommonResult.create(444, "查询失败id ："+id);
        }
    }

    @GetMapping("/ok")
    public String payment_ok(Long id){
      String string =   paymentService.paymentInfo_ok(id);
        log.info(string);
        return string;
    }

    @GetMapping("/timeout")
    public String payment_timeout(Long id){
        String str =paymentService.paymentInfo_timeOut(id);
        return str;
    }
}

package com.zzs.springcloud.service.impl;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public CommonResult<Payment> echo(Long id) {
        return new CommonResult<Payment>(401, "blockclass ====降级", null);
    }
}

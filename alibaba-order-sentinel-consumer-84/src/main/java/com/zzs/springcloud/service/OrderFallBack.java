package com.zzs.springcloud.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;

public class OrderFallBack {
    public static CommonResult<Payment> getOrderFallback(int id, Throwable e) {
        return new CommonResult<Payment>(402, "blockclass ====异常降级", null);
    }
}

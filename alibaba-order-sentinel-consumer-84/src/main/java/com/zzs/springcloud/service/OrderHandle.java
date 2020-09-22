package com.zzs.springcloud.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Payment;

public class OrderHandle {
    public static CommonResult<Payment> getOrderHandle(int id, BlockException exception) {
        return new CommonResult<Payment>(401, "blockclass ====限流降级", null);
    }
}

package com.zzs.springcloud.service;

import com.zzs.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@FeignClient(value = "storage-service-seata")
public interface StorageService {
    @PostMapping("/storage/updateStorage")
    public void updateStorage(@RequestParam("productId") Long productId, @RequestParam("count")Integer count);
}

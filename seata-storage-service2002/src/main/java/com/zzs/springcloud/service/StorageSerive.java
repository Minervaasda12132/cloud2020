package com.zzs.springcloud.service;

import com.zzs.springcloud.entities.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

public interface StorageSerive {

    void updateStorage(@RequestParam("productId") Long productId,@RequestParam("count")Integer count);
}

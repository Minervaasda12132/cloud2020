package com.zzs.springcloud.service;

import com.zzs.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "account-service-seata")
public interface AccountService {

    @PostMapping("/account/updateAccount")
    public void updateAccount(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money);

}

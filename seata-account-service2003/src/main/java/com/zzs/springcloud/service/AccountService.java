package com.zzs.springcloud.service;

import com.zzs.springcloud.entities.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    void updateAccount(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}

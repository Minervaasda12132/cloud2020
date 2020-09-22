package com.zzs.springcloud.controller;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccoutController {
    @Resource
    private AccountService accountService;

    @PostMapping("/updateAccount")
    public void updateAccount(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money){
        accountService.updateAccount(userId,money);
    }

}

package com.zzs.springcloud.service.impl;

import com.zzs.springcloud.dao.AccountDao;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void updateAccount(Long userId, BigDecimal money) {
        log.info("AccountService ---进入到账户余额");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        accountDao.updateAccount(userId,money);
        log.info("AccountService ---结束账户余额");

    }
}

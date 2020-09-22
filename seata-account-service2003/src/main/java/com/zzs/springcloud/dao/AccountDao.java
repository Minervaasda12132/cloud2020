package com.zzs.springcloud.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountDao {

    //使用金额
    void updateAccount(@Param("userId")Long userId,@Param("money")BigDecimal money);
}

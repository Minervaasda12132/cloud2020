package com.zzs.springcloud.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

public interface StorageDao {
    //修改库存
    void updateStorage(@Param("productId")Long productId,@Param("count")Integer count);


}

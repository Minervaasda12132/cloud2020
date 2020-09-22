package com.zzs.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzs.springcloud.entities.Payment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper extends BaseMapper<Payment> {
    int updateBatch(List<Payment> list);

    int updateBatchSelective(List<Payment> list);

    int batchInsert(@Param("list") List<Payment> list);

    int insertOrUpdate(Payment record);

    int insertOrUpdateSelective(Payment record);

    Payment selectId(Long id);
}
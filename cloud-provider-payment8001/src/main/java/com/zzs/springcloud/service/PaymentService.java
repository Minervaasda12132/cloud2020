package com.zzs.springcloud.service;

import java.util.List;
import com.zzs.springcloud.entities.Payment;
import com.baomidou.mybatisplus.extension.service.IService;
public interface PaymentService extends IService<Payment>{


    int updateBatch(List<Payment> list);

    int updateBatchSelective(List<Payment> list);

    int batchInsert(List<Payment> list);

    int insertOrUpdate(Payment record);

    int insertOrUpdateSelective(Payment record);

    Payment selectId(Long id);

}

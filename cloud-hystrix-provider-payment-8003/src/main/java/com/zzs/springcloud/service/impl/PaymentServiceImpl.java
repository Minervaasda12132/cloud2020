package com.zzs.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.dao.PaymentMapper;
import com.zzs.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int updateBatch(List<Payment> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Payment> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Payment> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(Payment record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Payment record) {
        return baseMapper.insertOrUpdateSelective(record);
    }

    @Override
    public Payment selectId(Long id) {
        return paymentMapper.selectId(id);

    }

    @Override
    public String paymentInfo_ok(Long id) {
        return "线程池" + Thread.currentThread().getName() + "payment id" + id + "\t" + "o(*￣︶￣*)o";
    }

    @Override
    public String paymentInfo_timeOut(Long id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "payment id" + id + "\t" + "o(*￣︶￣*)o" + "耗时" + timeNumber + "\t" + "o(*￣︶￣*)o";
    }


}

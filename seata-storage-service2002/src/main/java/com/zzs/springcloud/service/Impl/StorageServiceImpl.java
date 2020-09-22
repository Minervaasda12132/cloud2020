package com.zzs.springcloud.service.Impl;

import com.zzs.springcloud.dao.StorageDao;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.service.StorageSerive;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;

@Service
@Slf4j
public class StorageServiceImpl implements StorageSerive {
    @Resource
    private StorageDao storageDao;


    @Override
    public void updateStorage(Long productId, Integer count) {

        try {
            storageDao.updateStorage(productId, count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

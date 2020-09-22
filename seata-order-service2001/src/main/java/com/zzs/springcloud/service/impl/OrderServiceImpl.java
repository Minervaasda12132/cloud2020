package com.zzs.springcloud.service.impl;

import com.zzs.springcloud.dao.OrderDao;

import com.zzs.springcloud.entities.Order;
import com.zzs.springcloud.service.AccountService;
import com.zzs.springcloud.service.OrderService;
import com.zzs.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public void CreateOrder(Order order) {
        log.info("订单开始");
        orderDao.CreateOrder(order);
        log.info("订单结束");
        log.info("库存开始");
        storageService.updateStorage(order.getProductId(), order.getCount());
        log.info("库存结束");
        log.info("账户开始");
        accountService.updateAccount(order.getUserId(), order.getMoney());
        log.info("账户");
        log.info("状态修改开始");
        orderDao.UpdateOrder(order.getUserId(), order.getStatus());
        log.info("状态修改结束");

    }
}

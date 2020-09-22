package com.zzs.springcloud.dao;

import com.zzs.springcloud.entities.Order;

import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    Order selectOrder();

    //新建订单
    void CreateOrder(Order order);

    //修改订单状态
    void UpdateOrder(@Param("userId") Long userId, @Param("status") Integer status);
}

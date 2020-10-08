package com.zzs.springcloud.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzs.springcloud.entities.Order;
import org.apache.ibatis.annotations.Param;

public interface OrdersDao extends BaseMapper<Order> {
    Order selectById(@Param("id")Long id);
}

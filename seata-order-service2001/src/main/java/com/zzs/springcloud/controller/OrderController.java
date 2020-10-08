package com.zzs.springcloud.controller;

import com.zzs.springcloud.dao.OrderDao;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Order;
import com.zzs.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;


    /**
     * 添加订单
     * @return
     */
    @GetMapping("/addOrder")
    public void addOrder(Order order){
      orderService.CreateOrder(order);
    }


}

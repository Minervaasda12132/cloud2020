package com.zzs.springcloud.controller;

import com.zzs.springcloud.dao.OrdersDao;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.Order;
import com.zzs.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Resource
    private OrdersDao orderDao;

    public static HashMap<Long,Payment> hash1 = new HashMap<Long, Payment>();
    static {
        hash1.put(1L, new Payment(1l, "payment1"));
        hash1.put(1L, new Payment(2l, "payment2"));
        hash1.put(1L, new Payment(3l, "payment3"));
    }

/*   @GetMapping(value = "/payment/{id}")
    public String echo(@PathVariable Long id) {
        return "Hello Nacos Discovery " + port + "==id==" + id;
    }*/

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> echo(@PathVariable("id") Long id) {
        Payment payment = hash1.get(id);
       // int a =10/0;
        return new CommonResult<Payment>(200, "payment chenggong serverport"+port, payment);
    }

    @GetMapping("/test")
    public void toTest(){

       Order a =  orderDao.selectById(1L);
       log.info(a.toString());
       List<Order> b = orderDao.selectList(null);
       log.info(b.toString());
    }

}

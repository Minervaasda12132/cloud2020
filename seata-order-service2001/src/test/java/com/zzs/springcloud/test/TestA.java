package com.zzs.springcloud.test;

import com.zzs.springcloud.dao.OrderDao;
import com.zzs.springcloud.entities.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class TestA {
    @Resource
    private OrderDao orderDao;

    @Test
    public void testFindAll() {
        log.info("jinru test");
        Order a = Order.builder()
                .count(1)
                .money(BigDecimal.valueOf(11))
                .status(2)
                .userId(333L)
                .productId(222L)
                .build();
//        orderDao.insert(a);
        orderDao.selectList(null);
    }

    @Test
    public void testFind() {
        log.info("jinru test");
        List<Order> a = orderDao.selectOrder();
        log.info(a.toString());
    }

}

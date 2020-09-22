package com.zzs.springcloud.controller;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/testA")
    public String testA() {

        String str = null;
        try {
            str = Thread.currentThread().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(str);
        return "testA";
    }

    @GetMapping("/testB")
    @SentinelResource(value = "testB",
            blockHandler = "testBlockHandler",
            blockHandlerClass = {OrderHandle.class},
            fallback = "testBlockFallback",
            fallbackClass = {OrderFallback.class})
    public String testB(String p1, String p2) {
        int a = 10 / 0;
        return "testB";
    }



    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int s = 10 / 0;
        return "testD";
    }

    @GetMapping("/testE")
    public String testE() {
        int s = 10 / 0;
        return "testE";
    }


}

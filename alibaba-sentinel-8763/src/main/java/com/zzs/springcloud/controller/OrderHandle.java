package com.zzs.springcloud.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class OrderHandle {

    public static String testBlockHandler(String p1, String p2, BlockException block){

        return "testB  BlockHandler 限流降级-------"+block.getMessage();
    }
}

package com.zzs.springcloud.controller;

public class OrderFallback {
    public static String testBlockFallback(String p1, String p2, Throwable e) {

        return "testB  Fallback 异常降级-------" + e.getLocalizedMessage();
    }
}

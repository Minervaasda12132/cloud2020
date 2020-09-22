package com.zzs.springcloud.controller;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.service.StorageSerive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageSerive storageSerive;

    @PostMapping("/updateStorage")
    public void updateStorage(@RequestParam("productId") Long productId, @RequestParam("count")Integer count){
        storageSerive.updateStorage(productId,count);
    }
}

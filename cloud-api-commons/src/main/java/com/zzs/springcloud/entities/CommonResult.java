package com.zzs.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T> {
    private Integer code;
    private String message;
    private T data;


    public static <T> CommonResult<T> create(Integer code,String message,T data){
        return new CommonResult<T>(code,message,data);
    }
    public static <T> CommonResult<T> create(Integer code,String message){
        return new CommonResult<T>(code,message,null);
    }

}
package com.zzs.springcloud.util;

import org.apache.commons.lang3.StringUtils;

public class LevelUtil {
    //分隔符
    public final static String SEPARATOR = ".";
    //初始化
    public final static String ROOT = "0";

    //计算版本
    public static String calculateLevel(String parentLevel,Long parentId){
        //父版本为空则为 父版本
        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else {
            return StringUtils.join(parentLevel,"SEPARATOR",parentId);
        }

    }
}

package com.zzs.springcloud.service;

import com.google.common.collect.Multimap;
import com.zzs.springcloud.dto.DeptLevelDto;

import java.util.List;

public interface SysTreeService {
    //封装数据
    List<DeptLevelDto> deptTree();
}

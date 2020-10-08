package com.zzs.springcloud.service;

import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.SysDept;
import com.zzs.springcloud.vo.SysDeptVo;

public interface SysDeptService {
    //新增部门
    int saveDept(SysDeptVo sysDept);
    //修改部门
    void updateDept(SysDeptVo sysDept);
}

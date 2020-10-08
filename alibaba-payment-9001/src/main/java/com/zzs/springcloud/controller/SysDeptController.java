package com.zzs.springcloud.controller;

import com.zzs.springcloud.dto.DeptLevelDto;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.service.SysDeptService;
import com.zzs.springcloud.service.SysTreeService;
import com.zzs.springcloud.vo.SysDeptVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;

    @Resource
    private SysTreeService sysTreeService;
    /**
     * 新增部门
     * @param sysDeptVo
     * @param bindingResult
     * @return
     */
    @GetMapping("/save")
    public CommonResult saveDept(@Valid SysDeptVo sysDeptVo, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                List<String> list = new ArrayList();
                List<ObjectError> objectErrors = bindingResult.getAllErrors();
                for (ObjectError objectError : objectErrors) {
                    list.add(objectError.getDefaultMessage());
                }
                return CommonResult.create(402, StringUtils.join(list,"|"));
            }
            if (sysDeptService.saveDept(sysDeptVo)==0) {
                return CommonResult.create(401, "添加失败");
            }
            return CommonResult.create(200, "成功");

        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.create(500, "注册失败");
        }
    }

    @GetMapping("/update")
    public CommonResult updateDept(@Valid SysDeptVo sysDeptVo, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                List<String> list = new ArrayList();
                List<ObjectError> objectErrors = bindingResult.getAllErrors();
                for (ObjectError objectError : objectErrors) {
                    list.add(objectError.getDefaultMessage());
                }
                return CommonResult.create(402, StringUtils.join(list,"|"));
            }
            if (sysDeptService.saveDept(sysDeptVo)==0) {
                return CommonResult.create(401, "添加失败");
            }
            return CommonResult.create(200, "成功");

        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.create(500, "注册失败");
        }
    }

    /**
     * 获取部门树
     * @return
     */
    @GetMapping("/tree")
    public CommonResult getDeptTree(){
        List<DeptLevelDto> dtos= sysTreeService.deptTree();
        return CommonResult.create(200, "部门树",dtos);
    }


}

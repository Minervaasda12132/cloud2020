package com.zzs.springcloud.dto;

import com.google.common.collect.Lists;
import com.zzs.springcloud.entities.SysDept;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptLevelDto extends SysDept {

    private List<DeptLevelDto> deptList= Lists.newArrayList();

    public static  DeptLevelDto addpt(SysDept sysDept){
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(sysDept,dto);
        return dto;
    }
}

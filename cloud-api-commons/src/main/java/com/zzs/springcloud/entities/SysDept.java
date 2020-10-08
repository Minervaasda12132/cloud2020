package com.zzs.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "sys_dept")
public class SysDept {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String level;
    private Integer seq;
    private String remark;
    private Long parentId;
    private String operator;
    private Date operateTime;
    private String operateIp;
}

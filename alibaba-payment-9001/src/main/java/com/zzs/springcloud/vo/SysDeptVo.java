package com.zzs.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysDeptVo {
    private Long id;
    @NotBlank(message = "部门名称不允许为空")
    @Length(max = 20,message = "内容长度不能超过20")
    private String name;
    @NotNull(message = "展示顺序不允许为空")
    private Integer seq;
    @NotBlank(message = "备注不允许为空")
    @Length(max = 150,message = "内容长度不能超过150")
    private String remark;
    private Long parentId=0L;
}

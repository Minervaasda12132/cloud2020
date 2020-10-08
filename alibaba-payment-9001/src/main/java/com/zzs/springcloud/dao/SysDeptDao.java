package com.zzs.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzs.springcloud.entities.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDeptDao extends BaseMapper<SysDept> {
    List<SysDept> selectChildDept(@Param("level")String level);

    void batchUpdate(@Param("sysDepts")List<SysDept> sysDepts);

    int countByNameAndParentId(Long parentId,String name,Long id);
}

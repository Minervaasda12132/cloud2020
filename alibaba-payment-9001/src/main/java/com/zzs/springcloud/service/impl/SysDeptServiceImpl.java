package com.zzs.springcloud.service.impl;

import com.zzs.springcloud.dao.SysDeptDao;
import com.zzs.springcloud.dto.DeptLevelDto;
import com.zzs.springcloud.entities.CommonResult;
import com.zzs.springcloud.entities.SysDept;
import com.zzs.springcloud.service.SysDeptService;
import com.zzs.springcloud.util.LevelUtil;
import com.zzs.springcloud.vo.SysDeptVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Resource
    private SysDeptDao sysDeptDao;

    @Override
    public int saveDept(SysDeptVo sysDept) {

        SysDept sysDept1 = SysDept.builder()
                .name(sysDept.getName())
                .seq(sysDept.getSeq())
                .parentId(sysDept.getParentId())
                .remark(sysDept.getRemark())
                .build();
        sysDept1.setLevel(LevelUtil.calculateLevel(getLevel(sysDept.getParentId()), sysDept.getParentId()));
        sysDept1.setOperateIp("127.0.0.1");//TODO
        sysDept1.setOperateTime(new Date());
        sysDept1.setOperator("system");
        return sysDeptDao.insert(sysDept1);
    }

    @Override
    public void updateDept(SysDeptVo sysDept) {
        SysDept befor = sysDeptDao.selectById(sysDept.getId());
        String beforLevel = befor.getLevel();
        SysDept sysDept1 = SysDept.builder()
                .id(sysDept.getId())
                .name(sysDept.getName())
                .seq(sysDept.getSeq())
                .parentId(sysDept.getParentId())
                .remark(sysDept.getRemark())
                .build();
        sysDept1.setLevel(LevelUtil.calculateLevel(getLevel(sysDept.getParentId()), sysDept.getParentId()));
        sysDept1.setOperateIp("127.0.0.1");//TODO
        sysDept1.setOperateTime(new Date());
        sysDept1.setOperator("system_update");
        updateWithChild(beforLevel, sysDept1.getLevel(), sysDept1);
    }

    @Transient
    private void updateWithChild(String beforLevel, String afterLevel, SysDept sysDept1) {
        if (!beforLevel.equals(afterLevel)) {
            List<SysDept> sysDepts = sysDeptDao.selectChildDept(afterLevel);
            if (!CollectionUtils.isEmpty(sysDepts)) {
                for (SysDept sysDept : sysDepts) {
                    String level = sysDept.getLevel();
                    if (level.indexOf(beforLevel) == 0) {
                        level = afterLevel + level.substring(beforLevel.length());
                        sysDept.setLevel(level);
                    }
                }
            }
            sysDeptDao.batchUpdate(sysDepts);
        }
        sysDeptDao.updateById(sysDept1);

    }

    private boolean checkExist(Long parentId, String deptName, Long deptId) {
        return sysDeptDao.countByNameAndParentId(parentId,deptName,deptId)>0;//TODO
    }

    private String getLevel(Long parentId) {
        SysDept sysDept = sysDeptDao.selectById(parentId);
        if (sysDept == null) {
            return null;
        }
        return sysDept.getLevel();
    }


}

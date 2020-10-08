package com.zzs.springcloud.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.zzs.springcloud.dao.SysDeptDao;
import com.zzs.springcloud.dto.DeptLevelDto;
import com.zzs.springcloud.entities.SysDept;
import com.zzs.springcloud.service.SysTreeService;
import com.zzs.springcloud.util.LevelUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SysTreeServiceImpl implements SysTreeService {
    @Resource
    private SysDeptDao sysDeptDao;

    @Override
    public List<DeptLevelDto> deptTree() {
        //获取所有部门
        List<SysDept> sysDepts = sysDeptDao.selectList(null);
        List<DeptLevelDto> levelDtoList = Lists.newArrayList();
        for (SysDept sysDept : sysDepts) {
            DeptLevelDto dto =  DeptLevelDto.addpt(sysDept);
            levelDtoList.add(dto);
        }
        return deptListToTree(levelDtoList);
    }

    //部门树处理
    private List<DeptLevelDto> deptListToTree(List<DeptLevelDto> deptLevelDto){
        //如果为空输出空数组
        if (CollectionUtils.isEmpty(deptLevelDto)){
            return Lists.newArrayList();
        }
        Multimap<String,DeptLevelDto> multimap = ArrayListMultimap.create();

        //处理一级部门
        List<DeptLevelDto> rootList= Lists.newArrayList();
        for (DeptLevelDto dto : deptLevelDto) {
            multimap.put(dto.getLevel(),dto);
            //判断是否为一级部门
            if (LevelUtil.ROOT.equals(dto.getLevel())){
                rootList.add(dto);
            }
            //对一级部门进行根据seq从小到大排序
            Collections.sort(rootList, new Comparator<DeptLevelDto>() {
                @Override
                public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                    return o1.getSeq()-o2.getSeq();
                }
            });
            //递归生成树

        }
        transformDeptTree(rootList,LevelUtil.ROOT,multimap);
        return rootList;
    }

    //核心递归排序
    private void transformDeptTree(List<DeptLevelDto> rootList,String level,Multimap<String,DeptLevelDto> multimap){
        for (int i = 0; i < rootList.size(); i++) {
            //遍历每个元素
            DeptLevelDto dept = rootList.get(i);
            //处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level,dept.getId());
            //通过level找到对应List<DeptLevelDto>集合
            List<DeptLevelDto> temDept = (List<DeptLevelDto>) multimap.get(nextLevel);
            //处理下一次层级并通过SEQ排序
            Collections.sort(temDept, new Comparator<DeptLevelDto>() {
                @Override
                public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                    return o1.getSeq()-o2.getSeq();
                }
            });
            //赋值下级部门
            dept.setDeptList(temDept);
            transformDeptTree(temDept,nextLevel,multimap);
        }

    }




}

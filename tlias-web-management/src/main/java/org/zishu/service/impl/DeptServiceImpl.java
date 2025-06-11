package org.zishu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zishu.mapper.DeptMapper;
import org.zishu.mapper.EmpMapper;
import org.zishu.pojo.Dept;
import org.zishu.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired//自动注入Mapper生成在ioc容器中的接口的实现类对象
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override//重写DeptService接口中的findAll方法
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }
    @Override
    public void add(Dept dept) {
        //1.补全基础属性 - createTime,updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        //2.调用Mapper接口方法插入数据
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //1.补全基础属性 - updateTime
        dept.setUpdateTime(LocalDateTime.now());
        //2.调用Mapper接口方法更新数据
        deptMapper.update(dept);
    }

    /**
     *根据部门ID统计员工数量
     */
    @Override
    public int getCountEmpByDeptId(Integer deptId) {
        return empMapper.countEmpByDeptId(deptId);
    }
}

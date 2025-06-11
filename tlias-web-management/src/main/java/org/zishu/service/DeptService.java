package org.zishu.service;

import org.zishu.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     *查询所有的部门数据
     */
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    /**
     * 修改部门
     */
    void update(Dept dept);


    /**
     * 根据部门ID统计员工数量
     */
    int getCountEmpByDeptId(Integer id);
}

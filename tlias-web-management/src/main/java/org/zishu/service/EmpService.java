package org.zishu.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.zishu.pojo.Emp;
import org.zishu.pojo.EmpQueryParam;
import org.zishu.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    ;
    /**
     * 分页查询
     */
//    PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender, LocalDate begin, LocalDate end);

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     */
    void save(Emp emp);

    /**
     * 批量删除员工
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询员工信息
     */
    Emp getInfo(Integer id);
}

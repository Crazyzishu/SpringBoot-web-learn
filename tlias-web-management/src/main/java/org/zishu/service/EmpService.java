package org.zishu.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.zishu.pojo.Emp;
import org.zishu.pojo.EmpQueryParam;
import org.zishu.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    ;
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
//    PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender, LocalDate begin, LocalDate end);

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     */
    void save(Emp emp);
}

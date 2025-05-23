package org.zishu.service;

import org.zishu.pojo.Emp;
import org.zishu.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}

package org.zishu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zishu.mapper.EmpMapper;
import org.zishu.pojo.Emp;
import org.zishu.pojo.PageResult;
import org.zishu.service.EmpService;

import java.util.List;

@Service//将该类注册为Bean
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1.调用mapper接口查询总记录数
        Long total = empMapper.count();

        //2.调用mapper接口查询结果列表
        Integer start = (page-1)*pageSize;
        List<Emp> rows =  empMapper.list(start,pageSize);

        //3.封装结果PageResult
        return new PageResult<Emp>(total,rows);
    }
}

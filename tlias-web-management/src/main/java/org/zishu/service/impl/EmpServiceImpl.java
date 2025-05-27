package org.zishu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.zishu.mapper.EmpExprMapper;
import org.zishu.mapper.EmpMapper;
import org.zishu.pojo.*;
import org.zishu.pojo.EmpLog;
import org.zishu.service.EmpLogService;
import org.zishu.service.EmpService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service//将该类注册为Bean
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;
    /**
     * 原始分页查询操作
     */
//    @Autowired
//    private EmpMapper empMapper;
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        //1.调用mapper接口查询总记录数
//        Long total = empMapper.count();
//
//        //2.调用mapper接口查询结果列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> rows =  empMapper.list(start,pageSize);
//
//        //3.封装结果PageResult
//        return new PageResult<Emp>(total,rows);
//    }

    /**
     * PageHelper分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     * 注意事项：1.定义的SQl语句结尾不能加分号“；”
     *         2.PageHelper仅能对紧跟在其后的第一个查询语句进行分页处理
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());

        //2.执行查询
        List<Emp> empList = empMapper.list(empQueryParam);

        //3.解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;

        return new PageResult<Emp>(p.getTotal(),p.getResult());

    }

    /**
     * 新增员工
     */
    @Transactional(rollbackFor = {Exception.class})//事务管理 - 默认出现运行时异常RuntimeException才会回滚
    @Override
    public void save(Emp emp) {
        try {
            //1.保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);



            //2.保存员工工作经历 -- 批量
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                //遍历集合：为empId赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工："+emp);
            empLogService.insertLog(empLog);
        }


    }
}

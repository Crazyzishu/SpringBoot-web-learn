package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zishu.pojo.Emp;
import org.zishu.pojo.EmpQueryParam;
import org.zishu.pojo.PageResult;
import org.zishu.pojo.Result;
import org.zishu.service.EmpService;

import java.time.LocalDate;

/**
 * 员工管理控制器
 */
@RestController
@Slf4j
@RequestMapping ("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     */
//    @GetMapping//直接指定请求方式为GET
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
//        log.info("分页查询：{}，{},{},{},{},{}", page, pageSize , name, gender,  begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize,name, gender,  begin, end);
//        return Result.success(pageResult);
//    }
    @GetMapping//直接指定请求方式为GET
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }
}


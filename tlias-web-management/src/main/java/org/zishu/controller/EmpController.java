package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zishu.pojo.Emp;
import org.zishu.pojo.PageResult;
import org.zishu.pojo.Result;
import org.zishu.service.EmpService;

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
    @GetMapping//直接指定请求方式为GET
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询：{}，{}",page,pageSize);
        PageResult<Emp> pageResult = empService.page(page,pageSize);
        return Result.success(pageResult);
    }
}`

package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.zishu.pojo.Emp;
import org.zishu.pojo.EmpQueryParam;
import org.zishu.pojo.PageResult;
import org.zishu.pojo.Result;
import org.zishu.service.EmpService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 新增员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除员工 - List集合接收
     * @param ids -- 使用数组接收
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工信息：{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
}


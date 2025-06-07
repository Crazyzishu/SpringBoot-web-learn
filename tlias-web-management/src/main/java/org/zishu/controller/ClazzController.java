package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zishu.mapper.EmpMapper;
import org.zishu.pojo.*;
import org.zishu.service.ClazzService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询:{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }



    /**
     * 查询所有班级信息
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级信息");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }


}

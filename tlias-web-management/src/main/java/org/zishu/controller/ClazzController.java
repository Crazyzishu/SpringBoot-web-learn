package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zishu.pojo.*;
import org.zishu.service.ClazzService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 条件分页查询
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
        //List<Clazz> 表示这个集合中的每一个元素都是一个 Clazz 类型的对象。
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

    /**
     * 根据ID删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除班级" + id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加班级
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("新增部门:{}",clazz);
        clazzService.add(clazz);
        return Result.success(clazz);
    }

    /**
     * 根据id查询班级
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询班级信息:{}",id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息:{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }


}

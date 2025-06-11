package org.zishu.controller;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zishu.pojo.PageResult;
import org.zishu.pojo.Result;
import org.zishu.pojo.Student;
import org.zishu.pojo.StudentQueryParam;
import org.zishu.service.StudentService;

import java.util.List;

/**
 * 学生管理
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 条件分页查询学员
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询：{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 增加学员
     */
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("新增员工：{}",student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 根据id查询学员信息-->编辑按钮的查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查找学员：{}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    /**
     * 修改学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息:{}",student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 删除学员信息
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除学员信息：{}",ids);
        studentService.delete(ids);
        return Result.success();
    }

    /**
     * 学员违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,@PathVariable Integer score){
        log.info("学员:{},违纪扣分:{}",id,score);
        studentService.violation(id,score);
        return Result.success();
    }
}

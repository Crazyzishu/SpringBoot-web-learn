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

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查找学员：{}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }
}

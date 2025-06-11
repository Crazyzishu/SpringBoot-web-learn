package org.zishu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zishu.mapper.StudentMapper;
import org.zishu.pojo.PageResult;
import org.zishu.pojo.Student;
import org.zishu.pojo.StudentQueryParam;
import org.zishu.service.StudentService;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        //2.执行查询
        List<Student> studentList = studentMapper.list(studentQueryParam);

        //3.转化封装
        Page<Student> p = (Page<Student>) studentList;

        return new PageResult<Student>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 学员违纪扣分
     */
    @Override
    public void violation(Integer id,Integer score) {
        Student student = new Student();
        student.setId(id);
        student.setViolationScore(score);
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }
}

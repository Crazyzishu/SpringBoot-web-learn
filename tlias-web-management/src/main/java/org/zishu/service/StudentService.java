package org.zishu.service;

import org.zishu.pojo.PageResult;
import org.zishu.pojo.Student;
import org.zishu.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

public interface StudentService {

    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id,Integer score);

}

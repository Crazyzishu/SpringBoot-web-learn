package org.zishu.service;

import org.zishu.pojo.PageResult;
import org.zishu.pojo.Student;
import org.zishu.pojo.StudentQueryParam;

public interface StudentService {

    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfo(Integer id);
}

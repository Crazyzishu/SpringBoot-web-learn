package org.zishu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zishu.pojo.Student;
import org.zishu.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    @Insert("INSERT INTO student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time)" +
    "VALUES (#{name},#{no}, #{gender}, #{phone},#{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void insert(Student student);

    @Select("select id, name, no, gender, phone, id_card, is_college, " +
            "address, degree, graduation_date, clazz_id, violation_count," +
            " violation_score, create_time, update_time from student where id = #{id};")
    Student getById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    Student violation(Integer id,Integer score);

    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();

    @MapKey("ClazzName")
    List<Map<String, Object>> countStudentClassData();
}

package org.zishu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.zishu.pojo.Emp;
import org.zishu.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;


/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    // -----------------原始分页查询实现方式-----------------------
    /**
     * 查询总记录数
     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
//    public Long count();
//
//    /**
//     * 分页查询
//     * 查询返回的对象封装到Emp对象中
//     */
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
//    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 条件查询员工信息的方法
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 添加员工信息
     */
    @Options(useGeneratedKeys = true,  keyProperty = "id")//获取到生成的主键 -- 主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "VALUES (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID批量删除员工的基本信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工信息 以及 员工的工作经历信息
     */
    Emp getById(Integer id);

    /**
     * 根据ID更新员工的基本信息
     */
    void updateById(Emp emp);
}

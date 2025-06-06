package org.zishu.mapper;

import org.apache.ibatis.annotations.*;
import org.zishu.pojo.Emp;
import org.zishu.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


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

    /**
     * 统计员工职位人数
     * 此设计是为了处理动态字段、简化代码，并与 MyBatis 等框架的默认行为保持一致
     * key:value -- key:字段名(pos,num)，value:字段值(4,7)
     * Map无序，key重复时，后面的会覆盖前面的，无需指定@MapKey,加上也可
     * 当你使用 @MapKey("pos") 时，
     * MyBatis 会自动将每一行数据封装为一个 Map，并将这些 Map 放入一个 List 中
     * 因此，@MapKey("pos") 只是为了方便地将 pos 字段作为键来标识每一条记录，
     * 而不是直接生成最终需要的 Map<String, Integer>
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

}

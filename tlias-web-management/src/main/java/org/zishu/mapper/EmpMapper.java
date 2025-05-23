package org.zishu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zishu.pojo.Emp;

import java.util.List;


/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    public Long count();

    /**
     * 分页查询
     * 查询返回的对象封装到Emp对象中
     */
    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
}

package org.zishu.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zishu.pojo.Clazz;
import org.zishu.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    
    
    @Select("select c.*, e.name as master_name from clazz c left join emp e " +
            "on c.master_id = e.id")
    List<Clazz> findAll();

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void add(Clazz clazz);

    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz where id = #{id};")
    Clazz getById(Integer id);

    void updateById(Clazz clazz);
}

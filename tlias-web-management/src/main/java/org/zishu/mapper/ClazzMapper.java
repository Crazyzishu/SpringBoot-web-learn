package org.zishu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zishu.pojo.Clazz;
import org.zishu.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    
    
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz order by begin_date desc")
    List<Clazz> findAll();

    List<Clazz> list(ClazzQueryParam clazzQueryParam);
}

package org.zishu.mapper;

import org.apache.ibatis.annotations.Select;
import org.zishu.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.zishu.pojo.OperateLogQueryParam;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    @Select("select o.*,e.name operateEmpName from operate_log o left join emp e on o.operate_emp_id = e.id order by o.operate_time desc")
    List<OperateLog> list(OperateLogQueryParam operateLogQueryParam);

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    void insert(OperateLog log);


}

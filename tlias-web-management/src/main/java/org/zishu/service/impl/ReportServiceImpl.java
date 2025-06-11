package org.zishu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zishu.mapper.ClazzMapper;
import org.zishu.mapper.EmpMapper;
import org.zishu.mapper.StudentMapper;
import org.zishu.pojo.ClassOption;
import org.zishu.pojo.JobOption;
import org.zishu.service.ReportService;
import org.zishu.service.StudentService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private StudentMapper studentMapper;



    @Override
    public JobOption getEmpJobData() {
        //1.调用mapper接口，获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();//map:pos=教研主管，num=1

        //2.组装结果，并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 统计学员学历人数
     */
    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    /**
     * 统计每个班级学员人数
     */
    @Override
    public ClassOption getStudentCountData() {
        //1.调用mapper接口,获取统计数据
        List<Map<String,Object>> list = studentMapper.countStudentClassData();

        //2.组装结果,并返回
        List<Object> clazzList = list.stream().map(dataMap->dataMap.get("ClazzName")).toList();
        List<Object> dataList = list.stream().map(dataMap->dataMap.get("num")).toList();
        return new ClassOption(clazzList,dataList);
    }
}

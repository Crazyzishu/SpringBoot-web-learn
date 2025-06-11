package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zishu.pojo.ClassOption;
import org.zishu.pojo.JobOption;
import org.zishu.pojo.Result;
import org.zishu.service.ReportService;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    /**
     * 统计员工职位人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计员工职位人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别人数");
        List<Map<String, Object>> genderList= reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计学员学历人数
     * String 表示字段名（如 "gender"、"count"）
     * Object 表示字段值（可能是 String、Integer、Double 等）
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历人数");
        List<Map<String,Object>> DegreeList = reportService.getStudentDegreeData();
        return Result.success(DegreeList);
    }

    /**
     * 统计每个班级学生的数量
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计每个班级学员人数");
        ClassOption classOption = reportService.getStudentCountData();
        return Result.success(classOption);
    }
}




















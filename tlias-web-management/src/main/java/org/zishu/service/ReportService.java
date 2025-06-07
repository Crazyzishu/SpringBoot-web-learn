package org.zishu.service;

import org.zishu.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();
}

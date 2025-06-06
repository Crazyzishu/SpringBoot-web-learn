package org.zishu.service;

import org.zishu.pojo.JobOption;

public interface ReportService {

    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();
}

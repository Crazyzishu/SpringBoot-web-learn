package org.zishu.pojo;

import lombok.Data;

/**
 * 学生查询参数类
 */
@Data
public class StudentQueryParam {
    private String name;//姓名
    private Integer degree;//学历
    private Integer clazzId;//班级ID
    private Integer page;//页码
    private Integer pageSize;//每页数量
}

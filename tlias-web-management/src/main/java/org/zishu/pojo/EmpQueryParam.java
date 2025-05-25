package org.zishu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 请求参数类
 */
@Data
public class EmpQueryParam {
    private Integer page;//页码
    private Integer pageSize;//每页显示的记录数
    private String name;//姓名
    private Integer gender;//性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//入职时间-开始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//入职时间-结束
}

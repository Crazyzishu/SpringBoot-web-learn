package org.zishu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 请求参数类
 * 这些字段用于构建 SQL 查询语句中的 WHERE 条件、LIMIT 分页等。
 * 它的作用仅限于传递查询条件，不用于承载查询结果。
 */
@Data
public class ClazzQueryParam {
    private String name;//班级名称
    private Integer pageSize;//分页查询的每页记录数
    private Integer page;//分页查询的页码
    @DateTimeFormat(pattern = "YY-MM-DD")
    private LocalDate begin;//范围匹配的开始时间(结课时间)
    @DateTimeFormat(pattern = "YY-MM-DD")
    private LocalDate end;//范围匹配的结束时间(结课时间)
}

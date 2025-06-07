package org.zishu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 班级实体类
 * 首先是：
 * 封装数据库中的字段成属性
 * 其次查看接口文档添加数据库中没有的需要接收和响应的属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;//id
    private String name;//班级名称
    private String room;//班级教室
    private LocalDate beginDate;//开课时间
    private LocalDate endDate;//结课时间
    private Integer masterId;//班主任（员工ID）
    private Integer subject;//学科
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间

    private String masterName;//班主任姓名（员工姓名）
    private String status;//状态（未开班，已开班，已结课）
}

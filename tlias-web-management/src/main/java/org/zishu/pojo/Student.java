package org.zishu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学生实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private String gender;
    private String phone;
    private Integer degree;
    private String idCard;
    private Integer isCollege;
    private String address;
    private String graduationDate;
    private Integer violationCount;
    private Integer violationScore;
    private Integer clazzId;
    private String clazzName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

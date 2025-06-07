package org.zishu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Integer no;
    private Integer gender;
    private String phone;
    private Integer degree;
    private String idCard;
    private Integer idCollege;
    private String address;
    private String graduationDate;
    private Integer violationCount;
    private Integer violationScore;
    private Integer clazzId;
    private String clazzName;
    private String createTime;
    private String updateTime;
}

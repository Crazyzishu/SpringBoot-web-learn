package org.zishu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果封装类
 * 通过使用泛型 <T>，它可以支持任意类型的数据
 * 比如：
 * PageResult<Clazz>：班级信息的分页结果。
 * PageResult<Emp>：员工信息的分页结果。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}

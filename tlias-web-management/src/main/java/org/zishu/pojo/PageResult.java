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
 * 当我们使用 PageResult<Clazz> 时，
 * rows 字段就变成了 List<Clazz>，自然就可以存储多个 Clazz 对象了。
 * PageResult<Clazz> {
 *     total = 3,
 *     rows = [
 *         new Clazz(1, "Java班", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 6, 30)),
 *         new Clazz(2, "Python班", LocalDate.of(2025, 2, 1), LocalDate.of(2025, 7, 30))
 *     ]
 * }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}

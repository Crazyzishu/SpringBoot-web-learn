package org.zishu.service;

import org.zishu.pojo.Clazz;
import org.zishu.pojo.ClazzQueryParam;
import org.zishu.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    /**
     * 查询所有班级信息
     * 前面不添加static，因为实例方法可与 Spring 的依赖注入结合
     */
    List<Clazz> findAll();

    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 根据id删除班级
     */
    void deleteById(Integer id);

    void add(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);
}

package org.zishu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zishu.mapper.ClazzMapper;
import org.zishu.mapper.EmpMapper;
import org.zishu.pojo.Clazz;
import org.zishu.pojo.ClazzQueryParam;
import org.zishu.pojo.PageResult;
import org.zishu.service.ClazzService;

import java.time.LocalDate;
import java.util.List;

/**
 * 班级管理实现类
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 分页查询
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        //设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());

        //执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        //解析查询结果(转化)并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    /**
     * 查询所有班级信息
     * 根据开课时间、结课时间判断并设置Status返回前端
     */
    @Override
    public List<Clazz> findAll(){
        List<Clazz> clazzList =  clazzMapper.findAll();
        LocalDate now = LocalDate.now();//获取当前日期

        for(Clazz clazz : clazzList){
            if(now.isAfter(clazz.getEndDate())){
                clazz.setStatus("已结课");
            } else if (now.isBefore(clazz.getBeginDate())){
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        }
        return clazzList;
    }
}

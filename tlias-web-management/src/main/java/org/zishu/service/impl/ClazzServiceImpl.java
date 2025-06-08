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
import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级管理实现类
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 条件分页查询
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        //设置分页参数,传入页码和每页的数量
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());

        //执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        //解析查询结果(强制转化)并封装
        //Page实际上是一个增强版的 List，里面包含了 分页 信息
        //PageHelper 返回的对象实际上是一个
        //ArrayList 的子类或包装类，所以它可以兼容 List 的行为
        Page<Clazz> p = (Page<Clazz>) clazzList;

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

        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    /**
     * 查询所有班级信息
     * 根据开课时间、结课时间判断并设置Status返回前端
     */
    @Override
    public List<Clazz> findAll(){
//        List<Clazz> clazzList =  clazzMapper.findAll();
//        LocalDate now = LocalDate.now();//获取当前日期
//
//        for(Clazz clazz : clazzList){
//            if(now.isAfter(clazz.getEndDate())){
//                clazz.setStatus("已结课");
//            } else if (now.isBefore(clazz.getBeginDate())){
//                clazz.setStatus("未开班");
//            } else {
//                clazz.setStatus("在读中");
//            }
//        }
        return clazzMapper.findAll();
    }

    /**
     * 根据id删除班级信息
     */
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }
    /**
     * 新增班级
     */
    @Override
    public void add(Clazz clazz) {
        //设置创建时间和更新时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        //获取当前日期
        LocalDate now = LocalDate.now();

        //根据开课时间和结课时间设置班级状态
        if(now.isAfter(clazz.getEndDate())){
            clazz.setStatus("已结课");
        } else if (now.isAfter(clazz.getBeginDate())) {
            clazz.setStatus("未开班");
        } else {
            clazz.setStatus("在读中");
        }

        clazzMapper.add(clazz);
    }

    /**
     * 根据ID查询班级信息
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    /**
     * 修改班级信息
     */
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }
}

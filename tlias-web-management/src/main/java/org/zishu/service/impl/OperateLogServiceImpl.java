package org.zishu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zishu.mapper.OperateLogMapper;
import org.zishu.pojo.OperateLog;
import org.zishu.pojo.OperateLogQueryParam;
import org.zishu.pojo.PageResult;
import org.zishu.service.OperateLogService;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    OperateLogMapper operateLogMapper;


    @Override
    public PageResult<OperateLog> page(OperateLogQueryParam operateLogQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(operateLogQueryParam.getPage(), operateLogQueryParam.getPageSize());

        //2.执行查询
        List<OperateLog> operateLogList = operateLogMapper.list(operateLogQueryParam);

        //3.解析查询结果,并封装
        Page<OperateLog> p = (Page<OperateLog>) operateLogList;

        return new PageResult<OperateLog>(p.getTotal(),p.getResult());
    }
}

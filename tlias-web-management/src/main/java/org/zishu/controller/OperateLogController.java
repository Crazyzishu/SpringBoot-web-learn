package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zishu.pojo.OperateLog;
import org.zishu.pojo.OperateLogQueryParam;
import org.zishu.pojo.PageResult;
import org.zishu.pojo.Result;
import org.zishu.service.OperateLogService;

@Slf4j
@RestController
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/page")
    public Result Page(OperateLogQueryParam operateLogQueryParam){
        log.info("分页查询：{}",operateLogQueryParam);
        PageResult<OperateLog> pageResult = operateLogService.page(operateLogQueryParam);
        return Result.success(pageResult);
    }
}

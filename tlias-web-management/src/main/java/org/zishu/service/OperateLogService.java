package org.zishu.service;

import org.zishu.pojo.OperateLog;
import org.zishu.pojo.OperateLogQueryParam;
import org.zishu.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> page(OperateLogQueryParam operateLogQueryParam);
}

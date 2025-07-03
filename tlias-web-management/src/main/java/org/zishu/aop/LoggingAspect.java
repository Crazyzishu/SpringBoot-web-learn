package org.zishu.aop;

import org.zishu.pojo.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zishu.mapper.OperateLogMapper;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(org.zishu.anno.Log)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取操作人ID，这里假设通过某种方式获取当前登录用户ID
        Integer operateEmpId = getCurrentUser(); 

        // 获取目标类的全类名和方法名
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        // 获取方法参数
        String methodParams = Arrays.toString(joinPoint.getArgs());

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 计算方法执行时长
        long executionTime = System.currentTimeMillis() - startTime;

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(operateEmpId);
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(className);
        operateLog.setMethodName(methodName);
        operateLog.setMethodParams(methodParams);
        operateLog.setReturnValue(result == null ? "" : result.toString());
        operateLog.setCostTime(executionTime);

        // 插入日志到数据库
        operateLogMapper.insert(operateLog);

        return result;
    }

    private Integer getCurrentUser() {
        // 这里应该从上下文中获取当前登录用户的ID
        // 假设返回一个固定的ID作为示例
        return 1;
    }
}
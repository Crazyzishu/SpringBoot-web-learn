package org.zishu.aop;

import lombok.extern.slf4j.Slf4j;
import org.zishu.pojo.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zishu.mapper.OperateLogMapper;
import org.zishu.utils.CurrentHolder;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
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
        operateLog.setReturnValue(result == null ? "void" : result.toString());
        operateLog.setCostTime(executionTime);

        log.info("记录操作日志:{}",log);

        // 插入日志到数据库
        operateLogMapper.insert(operateLog);

        return result;
    }

    private Integer getCurrentUser() {
        return CurrentHolder.getCurrentId();
    }
}
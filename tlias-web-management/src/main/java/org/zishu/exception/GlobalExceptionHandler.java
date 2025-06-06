package org.zishu.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.zishu.pojo.Result;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice//声明当前是全局异常处理器
public class GlobalExceptionHandler {

    //此注解捕获并处理异常，通过捕获异常，可以将错误信息以统一的格式返回给前端，
    // 而不是直接暴露服务器的堆栈信息
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错了",e);
        return Result.error("服务器故障，请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程序出错了",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");//拿到Duplicate前一个字符的位置是‘90’
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");//按照空格分割字符串{'Duplicate''entry''手机号'}
        return Result.error(arr[2]+"已存在");//数组第三个元素是错误信息‘手机号’
    }
}

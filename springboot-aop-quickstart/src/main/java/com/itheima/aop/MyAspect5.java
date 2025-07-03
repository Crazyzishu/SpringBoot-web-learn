package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(3)
//@Aspect
public class MyAspect5 {
    //前置通知
//    @Before("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Before("execution(void delete(java.lang.Integer))")//包名.类名可以省略,但强烈不建议省略,性能低
//    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")//包名.类名可以省略,但强烈不建议省略,性能低
//    @Before("execution(* com.*.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Before("execution(* com.*.service.impl.*.delete(java.lang.Integer))")
//    @Before("execution(* com.*.service.impl.*.*(java.lang.Integer))")
//    @Before("execution(* com.*.service.impl.*.*(*))")
//    @Before("execution(* com.itheima.service.impl.*.del*(*))")
//    @Before("execution(* com.itheima.service.impl.*.*e(*))")
//    @Before("execution(* com..service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Before("execution(* com..service.impl.DeptServiceImpl.*(..))")
//    @Before("execution(* com.*.service.*.*(..))")
    //匹配list 与 delete方法
//    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) ||" +
//            "execution(* com.itheima.service.impl.DeptServiceImpl.delete(..))")
    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before(){
        log.info("MyAspect5 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.impl..*(..))")
    public void after(){
        log.info("MyAspect5 -> after ...");
    }
}

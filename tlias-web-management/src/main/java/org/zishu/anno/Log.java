package org.zishu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个配置类
 */

@Target(ElementType.METHOD)//指定此注解在哪生效 -- 只能加在方法上
@Retention(RetentionPolicy.RUNTIME)//指定此注解运行时生效
public @interface Log {
}

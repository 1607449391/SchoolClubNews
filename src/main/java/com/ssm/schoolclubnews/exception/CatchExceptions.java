package com.ssm.schoolclubnews.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *@author：
 *@time：2022-01-16 18:52
 *@description：
 *         全局捕获异常注解，加此注解，方法抛出的异常会被捕获统一处理
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CatchExceptions {
}

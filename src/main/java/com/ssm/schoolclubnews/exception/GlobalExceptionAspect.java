package com.ssm.schoolclubnews.exception;

import com.ssm.schoolclubnews.util.LoggerUtil;
import com.ssm.schoolclubnews.util.ResponseUtil;
import com.ssm.schoolclubnews.util.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 *@author：
 *@time：2022-01-16 19:12
 *@description：
 *
 */
@Aspect
@Component
@Slf4j
public class GlobalExceptionAspect {
    /**
     * 创建切面
     */
    @Pointcut("@annotation(com.ssm.schoolclubnews.exception.CatchExceptions)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            if (throwable instanceof GlobalException) {
                GlobalException globalException = (GlobalException) throwable;
                StatusCode code = globalException.getCode();
                LoggerUtil.error("", globalException);
                return ResponseUtil.fail(code.getCode(), code.getMsg());
            } else {
                LoggerUtil.error("", throwable);
                return ResponseUtil.fail(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMsg());
            }
        }
    }
}

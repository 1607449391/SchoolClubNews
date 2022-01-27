package com.ssm.schoolclubnews.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *@author：
 *@time：2022-01-27 15:19
 *@description：
 *        日志打印工具类
 */
public class LoggerUtil {

    private static final Logger log = LoggerFactory.getLogger(LoggerUtil.class);

    public static void info(String logText) {
        StringBuilder sb = new StringBuilder();
        getInvokeInfo(sb);
        sb.append("【info】:");
        log.info(sb.toString());
    }

    public static void info(String logText, String... params) {
        StringBuilder sb = new StringBuilder();
        getInvokeInfo(sb);
        sb.append("【info】:" + logText);
        log.info(sb.toString(), params);
    }

    public static void error(String logText) {
        StringBuilder sb = new StringBuilder();
        getInvokeInfo(sb);
        sb.append("【info】:" + logText);
        log.info(sb.toString());
    }

    public static void error(String logText, Throwable throwable) {
        log.info(logText, throwable);
    }

    /**
     * 获取当前登录用户信息
     *
     * @param sb 日志数据
     */
    private static void getUserInfo(StringBuilder sb) {

    }

    /**
     * 获取调用行信息
     *
     * @param sb 日志数据
     */
    private static void getInvokeInfo(StringBuilder sb) {
        sb.append("【methodInfo】:");
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        sb.append(className + "--");
        String methodName = stackTraceElement.getMethodName();
        sb.append(methodName + "--");
        int lineNumber = stackTraceElement.getLineNumber();
        sb.append(lineNumber + "--");
    }

}

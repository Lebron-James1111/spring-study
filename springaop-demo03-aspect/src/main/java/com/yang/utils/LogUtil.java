package com.yang.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 记录日志工具类
 * @author: CY.Ma
 * @date: 2023/7/4 13:58
 * @description:
 */
@Component
// 配置perthis表示切面为多例切面，bean也必须是多例的，每次调用都会创建一个新的切面对象
// 配置预处理的切入点表达式
//@Aspect("perthis(execution(* com.yang.service.impl.*.*(..)))") // 表明当前类是一个切面类
@Aspect
@Scope("prototype")
@Order(value = 1)
public class LogUtil {

    /**
     * 用于配置当前方法是一个前置通知
     */
    @Before(value = "execution(* com.yang.service.impl.*.*(..))")
    public void printLog() {
        System.out.println("执行打印日志的功能!");
    }
}

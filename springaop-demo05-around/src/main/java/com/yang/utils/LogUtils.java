package com.yang.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 21:46
 * @Description:
 * @doc:
 */
@Aspect
@Component
public class LogUtils {


    /**
     * 第一个*表示返回值为任意值
     * 第二个*表示service包下的任意类及其子类
     * 第三个*表示任意方法名
     * .. 表示任意参数
     */
//    @Before(value = "execution(* com.yang.service.*.*(..))")
    public void before() {
        System.out.println("记录日志成功!!");
    }

    /**
     * 用于增强业务层方法，在其执行时记录系统日志
     * @return
     */
    @Around("execution(* com.yang.service.*.*(..))")
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object rtValue = null;
        try {
            System.out.println("前置通知执行了!");
            try {
                // 获取切入点方法的参数
                Object[] args = joinPoint.getArgs();
                // 切入点方法执行
                rtValue = joinPoint.proceed(args);
            } finally {
                System.out.println("最终通知执行了!");
            }
            System.out.println("后置通知执行了");

        } catch (Throwable e) {
            System.out.println("异常通知执行了!");
            throw e;
        }

        return rtValue;
    }

}

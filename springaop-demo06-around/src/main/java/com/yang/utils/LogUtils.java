package com.yang.utils;

import com.alibaba.fastjson.JSON;
import com.yang.domain.SystemLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

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
//    @Around("execution(* com.yang.service.*.*(..))")
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


    @Around(value = "execution(* com.yang.service.*.*(..))")
    public Object aroundPrintLogPro(ProceedingJoinPoint joinPoint) throws Throwable{
        Object rtValue = null;
        try {
            System.out.println("环绕通知执行了记录日志!");
            rtValue = joinPoint.proceed();
            // 创建系统日志对象
            SystemLog log = new SystemLog();
            // 1.设置主键
            log.setId(UUID.randomUUID().toString());
            // 2.设置请求ip
            log.setRemoteIp("126.23.21.12");
            // 3.设置request
            log.setRequest(JSON.toJSONString(joinPoint.getArgs()));
            // 4.设置response
            log.setResponse(JSON.toJSONString(rtValue));
            // 5.设置时间
            log.setTime(new Date());
            // 6.设置方法
            // 6.1 获取方法签名
            Signature signature = joinPoint.getSignature();

            // 6.2 判断签名是否是方法签名
            if (signature instanceof MethodSignature) {
                // 6.3 强转方法签名
                MethodSignature methodSignature = (MethodSignature) signature;
                // 6.4 获取当前执行的方法
                Method method = methodSignature.getMethod();
                // 6.5 获取方法名称
                log.setMethod(joinPoint.getTarget().getClass().getName() + "." + method.getName());
                // 7.获取方法说明
                // 7.1 判断当前方法上是否有@Description注解
                boolean isAnnotatedMethod = method.isAnnotationPresent(Description.class);
                if (isAnnotatedMethod) {
                    // 7.2 得到当前方法上的@Description注解
                    Description description = method.getAnnotation(Description.class);
                    // 7.3 获取value属性
                    String value = description.value();
                    // 7.4 赋值
                    log.setDescription(value);
                }

            }
            System.out.println(JSON.toJSONString(log));
        } catch (Throwable e) {
            throw e;
        }
        return rtValue;
    }
}

package com.yang.utils;

import com.yang.domain.User;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 自定义切入点表达式
 * @author: CY.Ma
 * @date: 2023/7/5 14:50
 * @description:
 */
public class MyPointCut {

    /**
     * 用于定义通用的切入点表达式
     */
    @Pointcut(value = "execution(* com.yang.service.impl.*.*(..)) && args(user)")
    public void pointCut(User user){}
}

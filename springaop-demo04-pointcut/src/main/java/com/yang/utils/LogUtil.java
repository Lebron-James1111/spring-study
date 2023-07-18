package com.yang.utils;

import com.yang.domain.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 记录日志工具类
 * @author: CY.Ma
 * @date: 2023/7/4 13:58
 * @description:
 */
@Component
@Aspect
@Order(value = 1)
public class LogUtil {

    /**
     * 用于配置当前方法是一个前置通知
     */
    @Before(value = "com.yang.utils.MyPointCut.pointCut(user)", argNames = "user")
    public void printLog(User user) {
        System.out.println("执行打印日志的功能!" + user);
    }
}

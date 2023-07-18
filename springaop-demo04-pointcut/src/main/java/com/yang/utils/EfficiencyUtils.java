package com.yang.utils;

import com.yang.domain.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 用于统计方法执行效率工具类
 * @author: CY.Ma
 * @date: 2023/7/5 14:12
 * @description:
 *  如果不指定切面执行顺序，系统默认按照类的首字母进行排序，然后按照方法的首字母进行排序
 *  如果通过@Order指定了切面执行顺序，系统会按照指定的顺序执行
 */
@Component
@Aspect
@Order(value = 2)
public class EfficiencyUtils {

    private Long time;

    /**
     * 用于记录方法执行开始时间
     */
    @Before(value = "com.yang.utils.MyPointCut.pointCut(user)", argNames = "user")
    public void before(User user) {
        time = System.currentTimeMillis();
        System.out.println("方法执行开始时间" + time);
    }

    /**
     * 最终通知，用于记录方法执行时间
     */
    @After("execution(* com.yang.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法执行时间为:" + (System.currentTimeMillis() - time) + "毫秒");
    }
}

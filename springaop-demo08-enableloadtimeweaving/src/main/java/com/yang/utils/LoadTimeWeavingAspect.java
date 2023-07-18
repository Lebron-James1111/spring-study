package com.yang.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author: CY.Ma
 * @date: 2023/7/10 13:34
 * @description:
 */
@Aspect
//@Component // 为了运行期织入提供条件，类加载织入不需要此注解
public class LoadTimeWeavingAspect {

    @Pointcut(value = "execution(* com.yang.service.impl.UserServiceImpl.saveUser(com.yang.domain.User))")
    public void pointCut() {
    }

    /**
     * 统计方法执行效率
     * 希望开发环境和测试环境有，生产环境没有
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "pointCut()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        // 1.创建秒表对象
        StopWatch sw = new StopWatch(this.getClass().getSimpleName());
        try {
            // 2.记录执行时间
            sw.start(pjp.getSignature().getName());
            // 3.调用目标方法
            return pjp.proceed();
        } finally {
            sw.stop();
            // 4.打印方法执行耗时
            System.out.println(sw.prettyPrint());
        }

    }
}

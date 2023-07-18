package com.yang.utils;

import com.yang.domain.User;
import org.aspectj.lang.annotation.*;
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
     * 前置通知
     * 在切入点方法执行之前执行
     * 下面argNames名字只要保持一致即可，不需要与切入点表达式中的名称保持一致
     */
    @Before(value = "com.yang.utils.MyPointCut.pointCut(user111, test)", argNames = "user111, test")
    public void beforePrintLog01(User user111, String test) {
        System.out.println("前置通知增强方法01!" + user111 + " " + test);
    }

    /**
     * 同一个类相同类型的通知 执行顺序按方法名称每个字母的ASCII码排序执行，越小的越先执行，@Order注解对于同一个切面控制相同类型的通知执行顺序是无效的
     * 如果遇到方法重载，会继续按方法名继续比较
     * @param user111
     * @param test
     */
    @Before(value = "com.yang.utils.MyPointCut.pointCut(user111, test)", argNames = "user111, test")
    public void beforePrintLog02(User user111, String test) {
        System.out.println("前置通知增强方法02!" + user111 + " " + test);
    }


    /**
     * 最终通知
     * 在切入点方法执行之后执行
     */
    @After(value = "com.yang.utils.MyPointCut.pointCut(user, id)", argNames = "user, id")
    public void afterPrintLog(User user, String id) {
        System.out.println("最终通知增强方法!");
    }

    /**
     * 后置通知
     * 在切入点方法正常执行并返回之前执行
     *
     * 伪代码如下:
     *  try {
     *      try {
     *          前置通知
     *          切入点方法
     *      } finally {
     *          最终通知
     *      }
     *      后置通知
     *      return
     *  } catch {
     *      异常通知
     *      throw 异常
     *  }
     *  所以发现最终通知执行在后置通知之前
     */
    @AfterReturning(value = "execution(* com.yang.service.impl.*.findById(..)) && args(id)", returning = "user", argNames = "user,id")
    public void afterReturnPrintLog(User user, String id) {
        System.out.println("后置通知增强方法!" + user + id) ;
    }

    /**
     * 异常通知
     * 在切入点方法抛出异常之后执行
     *   argNames表示在增强方法中的参数名称，如果用到了returning或者throwing，那么argNames中必须包含returning或者throwing的参数
     *   args表示入参
     *   returning表示返回值
     *   throwing表示异常
     */
    @AfterThrowing(value = "com.yang.utils.MyPointCut.pointCut(user, id)", argNames = "user, id, e", throwing = "e")
    public void afterThrowingPrintLog(User user, String id, Throwable e) {
        System.out.println("异常通知增强了!" + e);
    }
}

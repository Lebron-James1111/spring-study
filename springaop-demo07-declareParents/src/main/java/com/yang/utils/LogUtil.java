package com.yang.utils;

import com.yang.domain.User;
import com.yang.extension.ValidateExtensionService;
import com.yang.extension.impl.ValidateExtensionServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Component;

/**
 * 记录日志工具类
 * @author: CY.Ma
 * @date: 2023/7/4 13:58
 * @description:
 */
@Component
@Aspect // 表明当前类是一个切面类
public class LogUtil {

    /**
     * 让目标类具备当前生命接口中的方法，用的也是动态代理
     * + 表示UserService接口的所有实现类
     * @DeclareParents注解让增强的类具有新的方法(动态的为一些类添加新的方法)
     */
    @DeclareParents(value = "com.yang.service.UserService+", defaultImpl = ValidateExtensionServiceImpl.class)
    private ValidateExtensionService validateExtensionService;

    /**
     * 用于配置当前方法是一个前置通知
     */
    @Before(value = "execution(* com.yang.service.impl.*.saveUser(..)) && this(validateExtensionService) && args(user)", argNames = "validateExtensionService,user")
    public void printLog(ValidateExtensionService validateExtensionService, User user) {
        // 验证用户名称是否合法
        // 类型强转
        if (validateExtensionService.checkUser(user)) {
            System.out.println("执行打印日志的功能!");
        } else {
            throw new IllegalArgumentException("用户昵称中存在非法字符!");
        }

    }
}

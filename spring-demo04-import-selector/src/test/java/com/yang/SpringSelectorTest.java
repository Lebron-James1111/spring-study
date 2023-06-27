package com.yang;

import com.yang.service.AccountService;
import com.yang.service.UserService;
import com.yang.service.utils.LogUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 13:53
 * @description:
 */
public class SpringSelectorTest {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext("com.yang.config");
    }

    @Test
    public void test() {
        UserService userService = ac.getBean("com.yang.service.impl.UserServiceImpl", UserService.class);
        userService.saveUser();
        AccountService accountService = ac.getBean("com.yang.service.impl.AccountServiceImpl", AccountService.class);
        accountService.save();
        LogUtils logUtils = ac.getBean("com.yang.service.utils.LogUtils", LogUtils.class);
        logUtils.log();
    }

    @Test
    public void test01() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}

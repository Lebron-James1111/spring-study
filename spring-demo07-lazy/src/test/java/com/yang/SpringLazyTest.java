package com.yang;

import com.yang.service.LazyUserService;
import com.yang.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 10:11
 * @description:
 */
public class SpringLazyTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.yang.config");
        UserService userService = ac.getBean("userService", UserService.class);
        userService.save();

        LazyUserService lazyUserService = ac.getBean("lazyUserService", LazyUserService.class);
        lazyUserService.save();

        LazyUserService lazyUserService1 = ac.getBean("lazyUserService", LazyUserService.class);
        Assert.assertEquals(lazyUserService1, lazyUserService);
    }
}

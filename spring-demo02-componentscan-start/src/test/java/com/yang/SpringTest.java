package com.yang;

import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/26 16:55
 * @description:
 */
public class SpringTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.yang.config");
        UserService userService = ac.getBean("myuserServiceImpl", UserService.class);
        userService.save();
    }
}

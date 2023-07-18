package com.yang;

import com.yang.domain.User;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CY.Ma
 * @date: 2023/7/4 14:02
 * @description:
 */
public class SpringAopTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setNickname("caicai");
        user.setUsername("蔡雪辰");
        userService.saveUser(user);
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setNickname("caicai");
        user.setUsername("蔡雪辰");

        List<User> list = new ArrayList<>();
        list.add(user);

        userService.saveAllUser(list);
    }
}

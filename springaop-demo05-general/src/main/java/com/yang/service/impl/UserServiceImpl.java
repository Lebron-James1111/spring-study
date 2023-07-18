package com.yang.service.impl;

import com.yang.domain.User;
import com.yang.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: CY.Ma
 * @date: 2023/7/4 13:57
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(User user, String id) {
        int i = 1/0;
        System.out.println("执行了保存用户 " + user + " " + id);
    }

    @Override
    public User findById(String id) {
        User user = new User();
        user.setNickname("caicai");
        user.setUsername("蔡雪辰");
        System.out.println("原始返回对象：" + user);
        return user;
    }

}

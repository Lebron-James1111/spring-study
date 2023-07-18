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
    public void saveUser(User user) {
        System.out.println("执行了保存用户 " + user);
    }

    @Override
    public void saveAllUser(List<User> users) {
        for (User user : users) {
            // 获取暴露出来的代理对象
            UserService proxyUserService = (UserService) AopContext.currentProxy();
            proxyUserService.saveUser(user);
        }
    }
}

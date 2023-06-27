package com.yang.service.impl;

import com.yang.service.UserService;

/**
 * 模拟用户业务层实现类
 * @author: CY.Ma
 * @date: 2023/6/27 10:33
 * @description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("模拟保存用户");
    }
}

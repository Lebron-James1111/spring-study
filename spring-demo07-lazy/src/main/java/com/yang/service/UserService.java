package com.yang.service;

import org.springframework.stereotype.Service;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 10:08
 * @description:
 */
@Service
public class UserService {

    public UserService() {
        System.out.println("UserService对象创建了");
    }

    public void save() {
        System.out.println("保存用户成功");
    }
}

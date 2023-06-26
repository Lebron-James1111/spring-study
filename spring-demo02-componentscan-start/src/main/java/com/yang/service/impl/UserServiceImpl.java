package com.yang.service.impl;

import com.yang.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: CY.Ma
 * @date: 2023/6/26 16:44
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户成功!");
    }
}

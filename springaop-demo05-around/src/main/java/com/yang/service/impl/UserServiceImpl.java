package com.yang.service.impl;

import com.yang.domain.User;
import com.yang.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 21:44
 * @Description:
 * @doc:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("保存了用户：" + user);
    }
}

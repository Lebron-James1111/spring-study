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

    @Override
    public User findById(String id) {
        User user = new User();
        user.setName("菜菜");
        user.setAge(23);
        user.setGender("女");
        return user;
    }

    @Override
    public void update(User user) {
        System.out.println("执行了更新用户：" + user);
    }

    @Override
    public void del(String id) {
        System.out.println("执行了删除用户：" + id);
    }
}

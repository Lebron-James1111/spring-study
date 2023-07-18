package com.yang.service;

import com.yang.domain.User;

import java.util.List;

/**
 * @author: CY.Ma
 * @date: 2023/7/4 13:57
 * @description:
 */
public interface UserService {

    /**
     * 模拟保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 模拟批量保存用户
     * @param users
     */
    void saveAllUser(List<User> users);
}

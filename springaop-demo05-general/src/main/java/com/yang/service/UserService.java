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
    void saveUser(User user, String id);

    /**
     * 模拟根据id查找用户
     * @param id
     * @return
     */
    User findById(String id);
}

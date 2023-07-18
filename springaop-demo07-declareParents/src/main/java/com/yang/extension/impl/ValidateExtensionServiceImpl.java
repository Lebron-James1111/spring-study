package com.yang.extension.impl;

import com.yang.domain.User;
import com.yang.extension.ValidateExtensionService;
import org.springframework.stereotype.Component;

/**
 * @author: CY.Ma
 * @date: 2023/7/6 16:54
 * @description:
 */
@Component
public class ValidateExtensionServiceImpl implements ValidateExtensionService {
    @Override
    public boolean checkUser(User user) {
        // 判断用户昵称中是否包含 "孙子"
        return !user.getNickname().contains("孙子");
    }
}

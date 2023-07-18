package com.yang.extension;

import com.yang.domain.User;

/**
 * 用于扩展用户Service验证的接口
 * @author: CY.Ma
 * @date: 2023/7/6 16:53
 * @description:
 */
public interface ValidateExtensionService {

    /**
     * 检查用户信息
     * @param user
     * @return
     */
    boolean checkUser(User user);
}

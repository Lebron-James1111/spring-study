package com.yang.service;

import com.yang.domain.User;
import org.springframework.context.annotation.Description;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 21:41
 * @Description:
 * @doc:
 */
public interface UserService {

    @Description("保存用户")
    void save(User user);

    @Description("根据主键查询用户")
    User findById(String id);

    @Description("更新用户")
    void update(User user);

    @Description("删除用户")
    void del(String id);
}

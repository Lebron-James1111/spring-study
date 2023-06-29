package com.yang.dao.impl;

import com.yang.dao.AccountDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 16:24
 * @description:
 * primary注解指定了当多个相同类型的类同时存在时，优先注入哪个
 */
@Repository
@Primary
public class AccountDao01Impl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("AccountDao01Impl保存了账户!!!");
    }
}

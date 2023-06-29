package com.yang.dao.impl;

import com.yang.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 16:24
 * @description:
 */
@Repository
public class AccountDao02Impl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("AccountDao02Impl保存了账户!!!");
    }
}

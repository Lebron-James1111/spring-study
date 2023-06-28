package com.yang.service.impl;

import com.yang.service.AccountService;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 14:10
 * @description:
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("保存账户金额成功!");
    }
}

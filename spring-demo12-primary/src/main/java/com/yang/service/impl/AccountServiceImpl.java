package com.yang.service.impl;

import com.yang.dao.AccountDao;
import com.yang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 16:25
 * @description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}

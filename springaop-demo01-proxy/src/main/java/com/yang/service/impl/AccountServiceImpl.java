package com.yang.service.impl;

import com.yang.dao.AccountDao;
import com.yang.domain.Account;
import com.yang.service.AccountService;
import com.yang.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

/**
 * 账户的业务层实现
 * @author: CY.Ma
 * @date: 2023/6/28 15:24
 * @description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Long id) {
        accountDao.delete(id);
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void transfer(String sourceName, String targetName, Double money) {
        // 1.根据名称查询转出账户
        Account sourceAccount = accountDao.findByName(sourceName);
        // 2.根据名称查询转入账户
        Account targetAccount = accountDao.findByName(targetName);

        // 3.转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        // 4.转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney() + money);
        // 5.更新转出账户
        accountDao.update(sourceAccount);

        // 模拟异常
        int i = 1 / 0;
        // 6.更新转入账户
        accountDao.update(targetAccount);


    }

}

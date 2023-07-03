package com.yang.service;

import com.yang.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 * @author: CY.Ma
 * @date: 2023/6/28 15:19
 * @description:
 */
public interface AccountService {

    void save(Account account);

    void update(Account account);

    void delete(Long id);

    Account findById(Long id);

    List<Account> findAll();

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Double money);

}

package com.yang.dao;

import com.yang.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 * @author: CY.Ma
 * @date: 2023/6/28 15:27
 * @description:
 */
public interface AccountDao {

    void save(Account account);

    void update(Account account);

    void delete(Long id);

    Account findById(Long id);

    List<Account> findAll();
}

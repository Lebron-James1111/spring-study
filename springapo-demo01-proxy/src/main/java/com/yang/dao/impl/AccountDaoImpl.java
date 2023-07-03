package com.yang.dao.impl;

import com.yang.dao.AccountDao;
import com.yang.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现
 * @author: CY.Ma
 * @date: 2023/6/28 15:28
 * @description:
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Account account) {
        jdbcTemplate.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from account where id = ? ",  id);
    }

    @Override
    public Account findById(Long id) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findByName(String name) {
        List<Account> accountList = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
        if (accountList.isEmpty()) {
            return null;
        }
        if (accountList.size() > 1) {
            throw new IllegalArgumentException("用户账户名不唯一!");
        }
        return accountList.get(0);
    }
}

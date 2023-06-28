package com.yang;

import com.yang.domain.Account;
import com.yang.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 15:49
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("caicai");
        account.setMoney(11000D);
        accountService.save(account);
    }

    @Test
    public void testUpdate() {
        Account account = accountService.findById(1L);
        account.setMoney(19D);
        accountService.update(account);
    }

    @Test
    public void delTest() {
        accountService.delete(1L);
    }

    @Test
    public void findAllTest() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

    }
}

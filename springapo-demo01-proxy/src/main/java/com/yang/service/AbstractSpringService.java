package com.yang.service;

import com.yang.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: CY.Ma
 * @date: 2023/7/3 23:03
 * @Description:
 * @doc:
 */
@Service
public abstract class AbstractSpringService {

    @Autowired
    private AccountService accountService;


    public void save() {
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }


}

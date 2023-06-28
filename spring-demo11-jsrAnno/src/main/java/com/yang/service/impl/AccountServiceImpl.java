package com.yang.service.impl;

import com.yang.dao.AccountDao;
import com.yang.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 16:25
 * @description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    /**
     * @Resource什么都不指定默认按照类型装配，当name和type都指定时，两个条件都要满足
     */
//    @Resource(name = "accountDao02Impl")
    /**
     * @Inject没有任何属性，默认只能通过类型装配(与@Autowired相似)
     * 通过@Named注解配置名称,@Named不能单独使用
     * @Autowired和@Named可以组合
     * @Inject和@Qualifier可以组合
      */
    @Inject
    @Named("accountDao02Impl")
    private AccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}

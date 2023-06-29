package com.yang;

import com.yang.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/29 09:40
 * @description:
 */
public class SpringPrimaryTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.saveAccount();
    }

}

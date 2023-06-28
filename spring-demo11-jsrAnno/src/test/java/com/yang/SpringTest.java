package com.yang;

import com.yang.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 16:29
 * @description:
 */
public class SpringTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        AccountService accountService = ac.getBean("accountServiceImpl", AccountService.class);
        accountService.saveAccount();
    }
}

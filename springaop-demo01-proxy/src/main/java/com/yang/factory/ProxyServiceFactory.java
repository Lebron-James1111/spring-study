package com.yang.factory;

import com.yang.service.AccountService;
import com.yang.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * 用户生产service代理对象的工厂
 * @author: CY.Ma
 * @date: 2023/7/3 21:47
 * @Description:
 * @doc:
 */
@Component
public class ProxyServiceFactory {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    @Bean("proxyAccountService")
    public AccountService getProxyAccountService() {
        // 1.创建代理对象
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        // 1.定义返回值
                        Object rtValue = null;
                        // 开启事务
                        Connection connection = transactionManager.begin();
                        try {
                            // 执行被代理对象的方法
                            rtValue = method.invoke(accountService, args);
                            transactionManager.commit(connection);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 提交事务
                            transactionManager.rollback(connection);
                        } finally {
                            // 释放资源
                            transactionManager.close(connection);
                        }
                        // 返回
                        return rtValue;
                    }
                });
    }
}

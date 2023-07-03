package com.yang;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: CY.Ma
 * @date: 2023/7/3 15:33
 * @description:
 */
public class ConnectionTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);

        // 如果使用dataSource.getConnection()获取连接，那么两次调用拿到的不是同一个连接
        //1.初始化事务同步管理器
        TransactionSynchronizationManager.initSynchronization();
        //2.使用spring的数据源工具类获取当前线程的连接
        Connection connection = DataSourceUtils.getConnection(dataSource);
        Connection connection1 = DataSourceUtils.getConnection(dataSource);

        Assert.assertSame(connection1, connection);
    }

}

package com.yang.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: CY.Ma
 * @date: 2023/7/3 16:09
 * @description:
 */
@Component
public class TransactionManager {

    @Autowired
    private DataSource dataSource;

    /**
     * 开启事务
     */
    public Connection begin() {
        try {
            //1.初始化事务同步管理器
            TransactionSynchronizationManager.initSynchronization();
            //2.使用spring的数据源工具类获取当前线程的连接
            Connection connection = DataSourceUtils.getConnection(dataSource);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Transaction begin failed!");
        }
    }

    /**
     * 提交事务
     */
    public void commit(Connection connection) {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.yang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * 数据库连接配置类
 * @author: CY.Ma
 * @date: 2023/6/28 10:31
 * @description:
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 开发环境数据源
     * 创建druid数据源
     * @return
     */
    @Bean(name = "dataSource")
    @Profile("dev")
    public DruidDataSource createDevDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 开发环境最大活动链接数:5
        dataSource.setMaxActive(5);
        return dataSource;
    }


    /**
     * 测试环境数据源
     * @return
     */
    @Bean(name = "dataSource")
    @Profile("fat")
    public DruidDataSource createFatDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 开发环境最大活动链接数:5
        dataSource.setMaxActive(25);
        return dataSource;
    }


    /**
     * 生产环境数据源
     * @return
     */
    @Bean(name = "dataSource")
    @Profile("pro")
    public DruidDataSource createProDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 开发环境最大活动链接数:5
        dataSource.setMaxActive(50);
        return dataSource;
    }
}

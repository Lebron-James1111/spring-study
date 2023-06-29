package com.yang.config;

import com.yang.condition.LinuxCondition;
import com.yang.condition.WindowsCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

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
     * 创建windows系统测试数据源
     * @return
     */
    @Bean(name = "windowsDataSource")
    @Conditional(WindowsCondition.class)
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println("create Window Bean!!!");
        return dataSource;
    }

    /**
     * 创建linux版本测试数据源
     * @param linuxDriver
     * @param linuxUrl
     * @param linuxUserName
     * @param linuxPassword
     * 当有相同的bean名称的bean注入容器，后注入的会覆盖之前的
     * 使用conditional注解时
     *  源码中有如下实现：
     *      假如存在同名的方法
     *      如果之前同名方法上的@Conditional的Condition类返回了false，表示不注入此类
     *          那么后续同名方法所注入的bean都会失败
     *  千万不要重名，重名之后会有bug，bug详见后面分析
     *  最终在测试类中拿到的bean的名称是windowsDataSource,但其实这个bean是linuxDataSource，通过getConnection可以校验
     */
    @Bean(name = "linuxDataSource")
    @Conditional(LinuxCondition.class)
    public DataSource createDataSource(@Value("${linux.driver}") String linuxDriver,
                                       @Value("${linux.url}") String linuxUrl,
                                       @Value("${linux.username}") String linuxUserName,
                                       @Value("${linux.password}") String linuxPassword) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(linuxDriver);
        dataSource.setUrl(linuxUrl);
        dataSource.setUsername(linuxUserName);
        dataSource.setPassword(linuxPassword);
        System.out.println("create Linux Bean!!!");
        return dataSource;
    }
}

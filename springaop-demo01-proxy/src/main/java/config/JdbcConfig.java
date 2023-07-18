package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 和Jdbc操作相关的配置类
 * @author: CY.Ma
 * @date: 2023/6/25 22:29
 * @Description:
 * @doc:
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
     * 创建JdbcTemplate对象，并且存入IOC容器
     * @return
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 创建数据源，并存入IOC容器
     * @return
     */
    @Bean("dataSource")
    public DataSource createDataSource() {
        // 1. 创建spring内置数据源对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 2. 给数据源提供必要的参数
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}

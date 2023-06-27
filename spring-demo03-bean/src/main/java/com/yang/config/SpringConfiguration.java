package com.yang.config;

import com.yang.annotion.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * spring配置类
 * @author: CY.Ma
 * @date: 2023/6/27 09:15
 * @description:
 */
@Configuration
public class SpringConfiguration {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    /**
     * 创建数据源对象
     * @return
     * autowireCandidate -- 是否支持当前bean对象被其他对象Autowired自动按照类型注入
     */
    @Bean(name = "dataSource", autowireCandidate = true)
    public DataSource createDataSource() {
        return new DriverManagerDataSource();
    }

    /**
     * 创建jdbcTemplate
     * @param
     * @return
     * 如果不指定name属性，bean的名称就是方法名
     */
    @Bean//(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        System.out.println("执行了没有参数的方法");
        return new JdbcTemplate(dataSource);
    }

    /**
     * 如果出现方法重载，将按照定义的顺序创建bean对象，会使用后面的方法
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        System.out.println("执行了有参数的方法");
        return new JdbcTemplate(dataSource);
    }

    @MyBean
    public JdbcTemplate createJdbcTemplate() {
        System.out.println("执行createJdbcTemplate方法");
        return new JdbcTemplate(dataSource);
    }
}

package com.yang.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 测试spring注解开发入门案例
 * @author: CY.Ma
 * @date: 2023/6/25 22:38
 * @Description:
 * @doc:
 */
public class SpringAnnotationTest {
    public static void main(String[] args) {
        // 1. 创建容器(基于注解的创建方式)
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        // 2. 根据bean的id获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 3. 执行操作
        jdbcTemplate.update("insert into account(name, money) values(?, ?)", "test", "12345");

    }
}

package com.yang;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 09:18
 * @description:
 */
public class SpringTest {

    private AnnotationConfigApplicationContext ac = null;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext("com.yang.config");
    }

    @Test
    public void test() {
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void test01() {
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        Assert.assertNotNull(jdbcTemplate);
    }

    @Test
    public void test02() {
        JdbcTemplate jdbcTemplate = ac.getBean("createJdbcTemplate", JdbcTemplate.class);
        Assert.assertNotNull(jdbcTemplate);
    }
}

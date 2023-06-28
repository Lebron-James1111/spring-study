package com.yang;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 10:36
 * @description:
 */
public class SpringConditionalTest {

    @Test
    public void test() throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.yang.config");
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());

    }
}

package com.yang;

import com.yang.config.JdbcConfig;
import com.yang.config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 10:06
 * @description:
 */
public class SpringImportTest {

    private AnnotationConfigApplicationContext ac = null;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext("com.yang.config");
    }

    @Test
    public void test() {
        SpringConfiguration springConfiguration = ac.getBean("springConfiguration", SpringConfiguration.class);
        System.out.println(springConfiguration);
    }

    @Test
    public void test01() {
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void test02() {
        JdbcConfig jdbcConfig = ac.getBean(JdbcConfig.class);
        System.out.println(jdbcConfig);
    }

    @Test
    public void test03() {
        // 1.获取容器中所有的bean的唯一标识
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}

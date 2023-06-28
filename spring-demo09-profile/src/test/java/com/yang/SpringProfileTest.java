package com.yang;

import com.alibaba.druid.pool.DruidDataSource;
import com.yang.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试类，需要指定不同的环境
 * @author: CY.Ma
 * @date: 2023/6/28 14:35
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
@ActiveProfiles("pro")
public class SpringProfileTest {

    @Autowired
    private DruidDataSource dataSource;

    @Test
    public void testDataSource() {
        System.out.println(dataSource.getMaxActive());
    }

}

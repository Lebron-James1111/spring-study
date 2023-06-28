package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring配置类
 * @author: CY.Ma
 * @date: 2023/6/27 15:53
 * @description:
 */
@Configuration
@Import({JdbcConfig.class})
@PropertySource(value = "classpath:jdbc.properties")
public class SpringConfiguration {
}

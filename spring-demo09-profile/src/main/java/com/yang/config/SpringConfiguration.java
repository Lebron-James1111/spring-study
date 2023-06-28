package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring配置类
 * @author: CY.Ma
 * @date: 2023/6/28 14:30
 * @description:
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
@Import({JdbcConfig.class})
public class SpringConfiguration {
}

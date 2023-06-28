package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 10:29
 * @description:
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties", "classpath:linux-jdbc.properties"})
@Import({JdbcConfig.class})
public class SpringConfiguration {
}

package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * spring核心配置类
 * @author: CY.Ma
 * @date: 2023/6/27 10:06
 * @description:
 *  通过Import注解可以导入其他配置类
 */
@Configuration
@Import({JdbcConfig.class})
public class SpringConfiguration {
}

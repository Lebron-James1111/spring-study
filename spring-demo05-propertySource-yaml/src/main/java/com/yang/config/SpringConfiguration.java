package com.yang.config;

import com.yang.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring配置类
 * @author: CY.Ma
 * @date: 2023/6/27 17:04
 * @description:
 */
@Configuration
@Import({JdbcConfig.class})
@PropertySource(value = "classpath:jdbc.yaml",
        factory = YamlPropertySourceFactory.class)
public class SpringConfiguration {
}

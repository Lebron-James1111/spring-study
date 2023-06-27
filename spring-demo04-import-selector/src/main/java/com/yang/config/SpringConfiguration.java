package com.yang.config;

import com.yang.selector.CustomerImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring核心配置类
 * @author: CY.Ma
 * @date: 2023/6/27 10:33
 * @description:
 */
@Configuration
@Import({CustomerImportSelector.class})
@ComponentScan(basePackages = {"com.yang.service.impl"})
public class SpringConfiguration {
}

package com.yang.config;

import com.yang.registry.CustomImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 14:49
 * @description:
 */
@Configuration
@Import({CustomImportBeanDefinitionRegistrar.class})
@ComponentScan(basePackages = {"com.yang.service.impl"})
public class SpringConfiguration {
}

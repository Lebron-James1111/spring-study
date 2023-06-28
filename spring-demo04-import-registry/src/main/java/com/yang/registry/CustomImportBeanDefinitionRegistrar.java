package com.yang.registry;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * 自定义bean定义注册器
 * 注册器注入的bean名称为简写的短类名
 * @author: CY.Ma
 * @date: 2023/6/27 14:51
 * @description:
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 定义表达式
     */
    private String expression;

    /**
     * 自定义扫包路径
     */
    private String customPackage;

    public CustomImportBeanDefinitionRegistrar() {
        try {
            // 1.读取properties文件，创建Properties对象
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customImport.properties");
            expression = properties.getProperty("custom.importselector.expression");
            customPackage = properties.getProperty("custom.importselector.scanPackage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现注册bean的功能(通过扫描指定包实现)
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 1.定义扫描包的集合
        List<String> basePackages = null;
        // 2.判断是否有@ComponentScan注解
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())) {
            // 3.取出注解的属性
            Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            // 4.获取属性为basePackages/value
            basePackages = Lists.newArrayList((String[]) annotationAttributes.get("basePackages"));
        }
        // 5.没有@ComponentScan注解时，list集合为null，如果有@ComponentScan，没有指定basePackages或value属性时，list的size是0
        if (basePackages == null || basePackages.isEmpty()) {
            basePackages = new ArrayList<>();
            String basePackage = null; // 用于记录@Import注解这个类所对应的包
            try {
                // 6.取出@Import注解类所在的包
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
                basePackages.add(basePackage);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // 判断用户是否自定义了扫包路径
        if (!StringUtils.isEmpty(customPackage)) {
            basePackages.add(customPackage);
        }

        // 8.创建类路径扫描器
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
        // 9.创建类型过滤器
        TypeFilter typeFilter = new AspectJTypeFilter(expression, CustomImportBeanDefinitionRegistrar.class.getClassLoader());
        // 10.把类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);
        // 11.扫描指定的包
        scanner.scan(basePackages.toArray(new String[0]));
    }
}

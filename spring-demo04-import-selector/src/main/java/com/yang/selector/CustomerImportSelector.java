package com.yang.selector;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 10:34
 * @description:
 */
public class CustomerImportSelector implements ImportSelector {

    /**
     * 导入表达式(Aspectj)
     */
    private String expression;

    /**
     * 用户自定义的扫把路径
     */
    private String customPackage;

    /**
     * 默认构造函数，用户读取配置文件给表达式赋值
     */
    public CustomerImportSelector() {
        try {
            // 1.获取properties对象
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customImport.properties");
            expression = properties.getProperty("custom.importselector.expression");
            customPackage = properties.getProperty("custom.importselector.scanPackage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现获取要导入类的字节码
     * 需求：
     *    导入的过滤规则TypeFilter采用aspectj
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 1.定义扫描包的名称
        List<String> basePackages = null;
        // 2.判断有@Import注解的类上是否有@ComponentScan注解
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())) {
            // 3.取出@ComponentScan注解的属性(basePackages/value)
            Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            if (Objects.nonNull(annotationAttributes)) {
                // 4.取出basePackage的值
                basePackages = new ArrayList<>(Arrays.asList((String[])annotationAttributes.get("basePackages")));
            }
        }
        // 5.判断是否有此注解，是否定义了包扫描的信息
        if (basePackages == null || basePackages.isEmpty()) {
            String basePackage = null;
            try {
                // 6.取出import注解注释的类所在包的名称
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // 7.把包名填充到basePackages
            basePackages = new ArrayList<>();
            basePackages.add(basePackage);
        }

        // 判断客户是否配置了自定一名
        if (!StringUtils.isEmpty(customPackage)) {
            basePackages.add(customPackage);
        }

        // 8.创建类路径扫描器,参数含义：不使用默认过滤规则
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        // 9.创建类型过滤器(此处使用的是Aspectj表达式的过滤器)
        TypeFilter typeFilter = new AspectJTypeFilter(expression, CustomerImportSelector.class.getClassLoader());
        // 10.把类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);
        // 11.定义要扫描类的全限定类名集合
        Set<String> classes = new HashSet<>();
        // 12.填充集合内容
        for (String basePackage : basePackages) {
            scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> classes.add(beanDefinition.getBeanClassName()));
        }
        // 13.按要求返回全限定类名的数组
        return classes.toArray(new String[0]);
    }
}

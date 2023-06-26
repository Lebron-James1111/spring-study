package com.yang.generator;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 自定义beanName生成器
 * @author: CY.Ma
 * @date: 2023/6/26 16:45
 * @description:
 */
public class CustomBeanNameGenerator implements BeanNameGenerator {

    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        // 0.定义bean名称
        String beanName = null;
        if (definition instanceof AnnotatedBeanDefinition) {
            // 1.判断bean是否被注解修饰
            AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) definition;
            AnnotationMetadata metadata = beanDefinition.getMetadata();
            Set<String> annotationTypes = metadata.getAnnotationTypes();
            // 2.遍历bean注解
            for (String annotationType : annotationTypes) {
                // 3.获取bean注解配置
                AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(annotationType, false));
                if (Objects.nonNull(attributes) && isStereotypeWithNameValue(annotationType, metadata.getAnnotationTypes(), attributes)) {
                    Object value = attributes.get("value");
                    if (value instanceof String) {
                        String strVal = (String) value;
                        if (StringUtils.hasLength(strVal)) {
                            beanName = strVal;
                        }
                     }
                }
            }
        }
        return beanName != null ? "my" + beanName : "my" + buildDefaultBeanName(definition);
    }

    protected boolean isStereotypeWithNameValue(String annotationType,
                                                Set<String> metaAnnotationTypes, @Nullable Map<String, Object> attributes) {

        // 判断是否是@Component注解或者是@Component注解的子类
        boolean isStereotype = annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME) ||
                metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME) ||
                annotationType.equals("javax.annotation.ManagedBean") ||
                annotationType.equals("javax.inject.Named");

        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }

    protected String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }

}

package com.yang.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 自定义注册bean的条件,windows操作系统注入
 * @author: CY.Ma
 * @date: 2023/6/28 10:45
 * @description:
 */
public class WindowsCondition implements Condition {

    /**
     * 是否注册到ioc容器中的方法
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return true表示注入，false表示不注入
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        // 1.获取ioc容器使用的beanFactory对象
//        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
//        // 2.获取类加载器
//        ClassLoader classLoader = conditionContext.getClassLoader();
//        // 3.获取环境信息，取出当前操作系统类型
//        Environment environment = conditionContext.getEnvironment();
//        if (environment instanceof StandardEnvironment) {
//            // 转换环境信息
//            StandardEnvironment standardEnvironment = (StandardEnvironment) environment;
//            Map<String, Object> systemEnvironment = standardEnvironment.getSystemProperties();
//            for (Map.Entry<String, Object> entry : systemEnvironment.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
//        }
//
//        // 4.获取bean定义信息的注册器
//        BeanDefinitionRegistry registry = conditionContext.getRegistry();
//        // 5.获取当前系统的名称
//        String osName = environment.getProperty("os.name");
//        // 6.判断是否包含windows规则
//        return !StringUtils.isEmpty(osName) && osName.contains("Windows");
        return true;
    }
}

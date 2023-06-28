package com.yang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;


/**
 * 自定义注册bean的条件,linux操作系统注入
 * @author: CY.Ma
 * @date: 2023/6/28 10:47
 * @description:
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
//        // 3.获取环境信息，取出当前操作系统类型
//        Environment environment = conditionContext.getEnvironment();
//        // 5.获取当前系统的名称
//        String osName = environment.getProperty("os.name");
//        // 6.判断是否包含windows规则
//
//        return !StringUtils.isEmpty(osName) && osName.contains("Mac");
    }
}

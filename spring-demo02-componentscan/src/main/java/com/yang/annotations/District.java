package com.yang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于定义区域的注解
 * @author: CY.Ma
 * @date: 2023/6/26 16:37
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface District {

    /**
     * 区域名称
     * @return
     */
    String value();
}


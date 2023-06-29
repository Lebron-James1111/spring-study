package com.yang.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: CY.Ma
 * @date: 2023/6/29 09:50
 * @description:
 */
@Component
public class LogUtil {

    public LogUtil() {
        System.out.println("LogUtil对象创建了!!");
    }

    @PostConstruct
    public void init() {
        System.out.println("对象初始化了!!");
    }

    /**
     * 当对象的scope是protoType时，容器销毁时并不会销毁对象
     * 对象的回收交由GC处理
     */
    @PreDestroy
    public void destroy() {
        System.out.println("对象销毁了!!");
    }
}

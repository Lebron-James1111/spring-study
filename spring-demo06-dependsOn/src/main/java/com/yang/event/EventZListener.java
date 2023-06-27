package com.yang.event;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * 监听器
 * @author: CY.Ma
 * @date: 2023/6/27 21:28
 * @Description:
 * @doc:
 */
@Component
public class EventZListener {

    public EventZListener() {
        System.out.println("事件源监听器创建了!");
    }
}

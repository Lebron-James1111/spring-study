package com.yang.event;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * 事件源对象
 * @author: CY.Ma
 * @date: 2023/6/27 21:27
 * @Description:
 * @doc:
 */
@Component
@DependsOn("eventZListener")
public class EventSource {

    public EventSource() {
        System.out.println("事件源对象创建了!");
    }
}

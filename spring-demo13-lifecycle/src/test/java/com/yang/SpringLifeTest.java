package com.yang;

import com.yang.utils.LogUtil;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/29 09:51
 * @description:
 */
public class SpringLifeTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        LogUtil logUtil = ac.getBean("logUtil", LogUtil.class);
        System.out.println(logUtil);
        ac.close();
    }
}

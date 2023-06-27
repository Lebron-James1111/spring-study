package com.yang;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/27 21:28
 * @Description:
 * @doc:
 */
public class SpringDependsOnTest {

    private AnnotationConfigApplicationContext ac = null;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext("com.yang.config");
    }

    @Test
    public void test() {
        ac.start();
    }
}

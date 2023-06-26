package com.yang;

import com.yang.service.DistrictPercentage;
import com.yang.service.DistrictPerformance;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/6/26 18:42
 * @description:
 */
public class SpringTest {

    @Test
    public void test() {
        // 1.创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("config");
        // 2.获取对象
        DistrictPercentage districtPercentage = applicationContext.getBean("districtPercentage", DistrictPercentage.class);
        // 3.执行方法
        districtPercentage.salePercentage("SUV");

        DistrictPerformance districtPerformance = applicationContext.getBean("districtPerformance", DistrictPerformance.class);
        districtPerformance.calcPerformance("SUV");

    }
}

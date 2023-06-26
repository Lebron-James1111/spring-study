package com.yang.service.northimpl;

import com.yang.annotations.District;
import com.yang.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 华北区绩效分成具体实现
 * @author: CY.Ma
 * @date: 2023/6/26 18:35
 * @description:
 */
@Service("districtPerformance")
@District("north")
public class NorthDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("华北区 " + type + " 绩效 3%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("华北区 " + type + " 绩效 5%");
        }
    }
}

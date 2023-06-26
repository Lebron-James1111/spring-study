package com.yang.service.southwestimpl;

import com.yang.annotations.District;
import com.yang.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 西南区绩效分成具体实现
 * @author: CY.Ma
 * @date: 2023/6/26 18:38
 * @description:
 *
 **/
@Service("districtPerformance")
@District("southWest")
public class SouthWestDistrictPerformance implements DistrictPerformance {
    @Override
    public void calcPerformance(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("西南区 " + type + " 绩效 5%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("西南区 " + type + " 绩效 3%");
        }
    }
}

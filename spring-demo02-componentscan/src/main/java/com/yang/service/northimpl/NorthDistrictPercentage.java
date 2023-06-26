package com.yang.service.northimpl;

import com.yang.annotations.District;
import com.yang.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 华北区销售分成具体实现
 * @author: CY.Ma
 * @date: 2023/6/26 18:33
 * @description:
 */
@Service("districtPercentage")
@District("north")
public class NorthDistrictPercentage implements DistrictPercentage {

    @Override
    public void salePercentage(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("华北区 " + type + " 提成 1%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("华北区 " + type + " 提成 0.5%");
        }
    }
}

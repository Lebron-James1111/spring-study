package com.yang.service.southwestimpl;

import com.yang.annotations.District;
import com.yang.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 西南区销售分成具体实现
 * @author: CY.Ma
 * @date: 2023/6/26 18:37
 * @description:
 */
@Service("districtPercentage")
@District("southWest")
public class SouthWestDistrictPercentage implements DistrictPercentage {
    @Override
    public void salePercentage(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("西南区 " + type + " 提成 1.5%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("西南区 " + type + " 提成 0.5%");
        }
    }
}

package com.yang.service;

/**
 * 提成计算调节接口
 * @author: CY.Ma
 * @date: 2023/6/26 16:38
 * @description:
 */
public interface DistrictPercentage {

    /**
     * 不同类型的提成不同
     *  CAR
     *  SUV
     * @param type
     */
    void salePercentage(String type);
}

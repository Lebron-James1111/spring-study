package com.yang.service;

/**
 * 绩效计算调节接口
 * @author: CY.Ma
 * @date: 2023/6/26 16:39
 * @description:
 */
public interface DistrictPerformance {

    /**
     * 根据不同车辆计算绩效
     *  CAR
     *  SUV
     * @param type
     */
    void calcPerformance(String type);
}

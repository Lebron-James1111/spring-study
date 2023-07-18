package com.yang.domain;

import java.io.Serializable;

/**
 * @author: CY.Ma
 * @date: 2023/7/4 10:09
 * @description:
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -6737386741583665457L;

    public void run() {
        System.out.println("car is running...");
    }

    public String print() {
        return "print";
    }
}

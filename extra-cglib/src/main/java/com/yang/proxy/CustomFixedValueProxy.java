package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;


/**
 * FixedValue回调示例
 * @author: CY.Ma
 * @date: 2023/7/4 11:01
 * @description:
 *  FixedValue一般用于替换方法的返回值为回调方法的返回值，但必须保证返回类型是兼容的，否则会出转换异常。
 */
public class CustomFixedValueProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "test";
            }
        });

        Car car = (Car) enhancer.create();
        System.out.println(car);
        System.out.println(car.print());
    }
}

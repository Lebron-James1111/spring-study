package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;


/**
 * NoOp回调示例
 * @author: CY.Ma
 * @date: 2023/7/4 10:17
 * @description:
 *  相当于没有任何代理逻辑，直接调用被代理类的方法
 */
public class CustomNoOpProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new NoOp() {
        });

        Car car = (Car) enhancer.create();
        car.run();
    }
}

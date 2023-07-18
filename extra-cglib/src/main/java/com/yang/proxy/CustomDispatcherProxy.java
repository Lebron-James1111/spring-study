package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;

/**
 * Dispatcher回调示例
 * @author: CY.Ma
 * @date: 2023/7/4 10:27
 * @description:
 *  与LazyLoader类似，但是Dispatcher每次都会回调loadObject方法，而LazyLoader只会回调一次
 */
public class CustomDispatcherProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new Dispatcher() {
            @Override
            public Object loadObject() {
                System.out.println("prepare loading...");
                Car car = new Car();
                System.out.println("after loading...");
                return car;
            }
        });

        Car car = (Car) enhancer.create();
        car.run();
        car.run();
    }
}

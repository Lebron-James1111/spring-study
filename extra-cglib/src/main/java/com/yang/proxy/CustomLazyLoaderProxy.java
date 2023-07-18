package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

/**
 * LazyLoader回调示例
 * @author: CY.Ma
 * @date: 2023/7/4 10:22
 * @description:
 *  当被增强的类被调用时，会回调LazyLoader的loadObject方法，该方法返回被代理类的实例
 *  之后再调用被代理类的方法，都是对LazyLoader第一次返回的bean进行调用
 */
public class CustomLazyLoaderProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new LazyLoader() {
            @Override
            public Object loadObject() throws Exception {
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

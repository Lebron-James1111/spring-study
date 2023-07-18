package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * InvocationHandler回调示例
 * @author: CY.Ma
 * @date: 2023/7/4 10:31
 * @description:
 *  cglib的InvocationHandler和JDK自带的InvocationHandler作用基本相同
 *  使用的时候要注意，如果对参数中的method再次调用，会重复进入InvocationHandler。
 */
public class CustomInvocationHandlerProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("override origin method!!");
                return null;
            }
        });

        Car car = (Car) enhancer.create();
        car.run();
    }
}

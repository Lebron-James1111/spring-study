package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * MethodProxy回调示例
 * @author: CY.Ma
 * @date: 2023/7/4 10:11
 * @description:
 *  相当于方法拦截器，在方法前后织入需要实现的逻辑
 */
public class CustomMethodProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, net.sf.cglib.proxy.MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                // 这里一定要要使用methodProxy.invoke，如果使用method.invoke会出现死循环
                Object result = methodProxy.invoke(o, args);
                System.out.println("after...");
                return result;
            }
        });

        Car car = (Car) enhancer.create();
        car.run();
    }
}

package com.yang.proxy;

import com.yang.domain.Car;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * 定制化proxy filter
 * @author: CY.Ma
 * @date: 2023/7/4 11:08
 * @description:
 *  根据原方法的返回类型指定特定的回调方法
 *  如果返回String类型则进行增强，如果返回其他类型则不进行方法增强
 */
public class CustomCallbackFilterProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        CallbackHelper helper = new CallbackHelper(Car.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "test";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };

        enhancer.setCallbacks(helper.getCallbacks());
        enhancer.setCallbackFilter(helper);

        Car car = (Car) enhancer.create();
        car.run();
        System.out.println(car.print());
    }
}

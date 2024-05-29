package spi;

import com.google.common.base.Preconditions;
import lombok.SneakyThrows;
import spi.annotation.SingletonSPI;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * SPI核心类，用于加载SPI，并根据参数判断是否需要生成多例
 * @author: CY.Ma
 * @date: 2024/3/22 16:54
 * @description:
 */
public class RegisteredSPI<T> {

    private final Class<T> serviceInterface;

    private final List<T> services;

    public RegisteredSPI(final Class<T> serviceInterface) {
        this.serviceInterface = serviceInterface;
        validate();
        services = load();
    }

    private void validate() {
        Preconditions.checkNotNull(serviceInterface, "SPI interface is null!");
        Preconditions.checkArgument(serviceInterface.isInterface(), "SPI %s is not an interface!", serviceInterface);
    }

    private List<T> load() {
        List<T> result = new LinkedList<>();
        // ServiceLoader本身实现了Iterable接口直接进行遍历
        for (T each : ServiceLoader.load(serviceInterface)) {
            result.add(each);
        }
        return result;
    }

    List<T> getServiceInstances() {
        return null == serviceInterface.getAnnotation(SingletonSPI.class) ? createNewServiceInstances() : getSingletonServiceInstances();
    }

    @SneakyThrows(ReflectiveOperationException.class)
    @SuppressWarnings("unchecked")
    private List<T> createNewServiceInstances() {
        List<T> result = new LinkedList<>();
        for (Object each : services) {
            result.add((T) each.getClass().getDeclaredConstructor().newInstance());
        }
        return result;
    }

    private List<T> getSingletonServiceInstances() {
        return services;
    }
}

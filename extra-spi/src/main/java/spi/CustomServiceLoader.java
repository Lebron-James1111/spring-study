package spi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义SPI加载器，主要负责缓存逻辑
 * @author: CY.Ma
 * @date: 2024/3/22 17:18
 * @description:
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomServiceLoader {

    private static final Map<Class<?>, RegisteredSPI<?>> REGISTERED_SERVICES = new ConcurrentHashMap<>();

    private static final Object LOAD_LOCK = new Object();

    @SuppressWarnings("unchecked")
    public static <T> List<T> getServiceInstances(final Class<T> serviceInterface) {
        return (List<T>) getRegisteredSPI(serviceInterface).getServiceInstances();
    }

    // <T>指定泛型方法，<?>表示RegisteredSPI包含的泛型是任意类型
    private static <T> RegisteredSPI<?> getRegisteredSPI(final Class<T> serviceInterface) {
        RegisteredSPI<?> result = REGISTERED_SERVICES.get(serviceInterface);
        if (null != result) {
            return result;
        }
        synchronized (LOAD_LOCK) {
            if (!REGISTERED_SERVICES.containsKey(serviceInterface)) {
                REGISTERED_SERVICES.put(serviceInterface, new RegisteredSPI<>(serviceInterface));
            }
        }
        return REGISTERED_SERVICES.get(serviceInterface);
    }
}


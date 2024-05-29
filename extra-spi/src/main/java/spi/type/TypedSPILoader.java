package spi.type;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import spi.CustomServiceLoader;

import java.util.Optional;
import java.util.Properties;

/**
 * 带类型的SPI加载器
 * @author: CY.Ma
 * @date: 2024/3/26 16:58
 * @description:
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TypedSPILoader {

    public static <T extends TypedSPI> Optional<T> findService(final Class<T> serviceInterface, final Object type) {
        return findService(serviceInterface, type, new Properties());
    }

    public static <T extends TypedSPI> Optional<T> findService(final Class<T> serviceInterface, final Object type, final Properties props) {
        if (null == type) {
            return findDefaultService(serviceInterface, props);
        }
        for (T each : CustomServiceLoader.getServiceInstances(serviceInterface)) {
            if (matchesType(type, each)) {
                each.init(null == props ? new Properties() : convertToStringTypedProperties(props));
                return Optional.of(each);
            }
        }
        return Optional.empty();
    }

    private static <T extends TypedSPI> Optional<T> findDefaultService(final Class<T> serviceInterface, final Properties props) {
        for (T each : CustomServiceLoader.getServiceInstances(serviceInterface)) {
            if (!each.isDefault()) {
                continue;
            }
            each.init(null == props ? new Properties() : convertToStringTypedProperties(props));
            return Optional.of(each);
        }
        return Optional.empty();
    }

    private static Properties convertToStringTypedProperties(final Properties props) {
        if (props.isEmpty()) {
            return props;
        }
        Properties result = new Properties();
        props.forEach((key, value) -> result.setProperty(key.toString(), null == value ? null : value.toString()));
        return result;
    }

    private static boolean matchesType(final Object type, final TypedSPI instance) {
        Object instanceType = instance.getType();
        if (null == instanceType) {
            return false;
        }
        if (instanceType instanceof String && type instanceof String) {
            return instanceType.toString().equalsIgnoreCase(type.toString()) || instance.getTypeAliases().contains(type);
        }
        return instanceType.equals(type) || instance.getTypeAliases().contains(type);
    }
}

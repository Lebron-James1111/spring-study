package spi.type;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 带类型的SPI抽象接口
 * @author: CY.Ma
 * @date: 2024/3/26 17:02
 * @description:
 */
public interface TypedSPI {

    /**
     * 默认初始化方法
     * @param props
     */
    default void init(final Properties props) {
    }

    /**
     * 获取SPI type信息
     * @return object type
     */
    Object getType();

    /**
     * 获取SPI的别名
     * @return
     */
    default List<Object> getTypeAliases() {
        return Collections.emptyList();
    }

    /**
     * 判断当前SPI是否为默认SPI
     * @return
     */
    default boolean isDefault() {
        return false;
    }
}

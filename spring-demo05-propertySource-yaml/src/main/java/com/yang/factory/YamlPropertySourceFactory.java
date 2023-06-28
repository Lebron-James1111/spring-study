package com.yang.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 解析yaml文件的工厂类
 * @author: CY.Ma
 * @date: 2023/6/27 17:15
 * @description:
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        // 1.创建yaml文件解析工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        // 2.设置要解析的资源内容
        factoryBean.setResources(resource.getResource());
        // 3.把资源解析成properties文件
        Properties properties = factoryBean.getObject();
        // 4.返回一个PropertySource对象
        return (name != null ? new PropertiesPropertySource(name, properties)
                : new PropertiesPropertySource(resource.getResource().getFilename(), properties));
    }
}

package support.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 15:41
 * @description:
 */
public class YamlPropertiesSourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        Properties properties = factoryBean.getObject();
        return (name != null ? new PropertiesPropertySource(name, properties)
                : new PropertiesPropertySource(resource.getResource().getFilename(), properties));
    }
}

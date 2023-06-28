package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import support.factory.YamlPropertiesSourceFactory;

/**
 * spring配置类
 * @author: CY.Ma
 * @date: 2023/6/28 15:34
 * @description:
 */
@Configuration
@ComponentScan(basePackages = {"com.yang"})
@PropertySource(value = {"classpath:jdbc.yaml"}, factory = YamlPropertiesSourceFactory.class)
@Import(value = {JdbcConfig.class})
public class SpringConfiguration {
}

package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring配置类，相当于applicationContext.xml
 * @author: CY.Ma
 * @date: 2023/6/25 22:26
 * @Description:
 * @doc:
 */
@Configuration
// 引入properties配置
@PropertySource(value = "classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfiguration {
}

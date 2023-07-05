package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 21:40
 * @Description:
 * @doc:
 */
@Configuration
@ComponentScan(basePackages = {"com.yang"})
@EnableAspectJAutoProxy
public class SpringConfiguration {
}

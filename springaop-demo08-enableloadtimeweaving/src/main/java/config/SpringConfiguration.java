package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * @author: CY.Ma
 * @date: 2023/7/4 13:59
 * @description:
 */
@Configuration
@ComponentScan(basePackages = "com.yang")
// exposeProxy 是否暴露代理对象 暴露之后通过AopContext获取代理对象
//@EnableAspectJAutoProxy(exposeProxy = true) // 开启spring注解aop配置的支持，采用运行期增强的注解
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED) // 开启类加载时期的增强
public class SpringConfiguration {
}

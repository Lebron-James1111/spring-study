package config;

import com.yang.typeFilter.DistrictTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * spring配置类
 * @author: CY.Ma
 * @date: 2023/6/26 18:41
 * @description:
 * 这里使用includeFilters自定义Filter时，必须useDefaultFilters = false
 * 因为DefaultFilters会将@Component及@Component注解的子类自动放行
 */
@Configuration
@ComponentScan(basePackages = {"com.yang"},
        includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = DistrictTypeFilter.class),
        useDefaultFilters = false)
public class SpringConfiguration {
}

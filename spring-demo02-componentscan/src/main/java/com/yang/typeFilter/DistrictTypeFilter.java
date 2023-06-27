package com.yang.typeFilter;

import com.yang.annotations.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author: CY.Ma
 * @date: 2023/6/26 22:12
 * @Description:
 * @doc:
 */
public class DistrictTypeFilter extends AbstractTypeHierarchyTraversingFilter {

    /**
     * 定义路径校验的对象
     */
    private PathMatcher pathMatcher;

    /**ykZ
     * 定义区域名称(从配置文件获取)
     * 不能使用@Value注解读取properties配置文件的内容
     * 因为负责填充属性值的InstantiationAwareBeanPostProcessor与TypeFilter实例创建不是一回事
     */
    private String districtName;

    /**
     * 定义可以处理的类的类名，指定package下
     */
    private static final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("com.yang.service.*.*");


    public DistrictTypeFilter() {
        // 不考虑基类，不考虑接口上的信息
        super(false, false);
        // 借助Spring默认的Resource通配符路径方式
        pathMatcher = new AntPathMatcher();
        // 读取配置文件
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
            // 给districtName赋值
            districtName = properties.getProperty("common.district.name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 本类将注册为Exclude,返回true表示拒绝
     * @param className
     * @return
     */
    @Override
    protected boolean matchClassName(String className) {
        try {
            // 判断是否在指定包下的类(只处理和区域相关的业务类)
            if (!isPotentialPackageClass(className)) {
                // 不符合路径规则
                return false;
            }
            // 判断当前区域与配置的区域是否一致，不一致则不能注册到spring的ioc容器中
            Class<?> clazz = ClassUtils.forName(className, DistrictTypeFilter.class.getClassLoader());
            // 获取@District注解
            District district = clazz.getAnnotation(District.class);
            // 判断是否有此注解
            if (Objects.isNull(district)) {
                return false;
            }
            // 取出注解的属性
            String districtValue = district.value();
            // 校验，如果取出的value属性值与配置文件中提供的一致，则注册到ioc容器中，返回true，否则返回true
            return districtName.equalsIgnoreCase(districtValue);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 本类逻辑中可以处理的类
     * @param className
     * @return
     */
    private boolean isPotentialPackageClass(String className) {
        // 1.将类名转换成为资源路径，以匹配是否符合扫描条件
        String path = ClassUtils.convertClassNameToResourcePath(className);
        // 2.校验规则
        return pathMatcher.match(PATTERN_STANDARD, path);
    }

}

package com.wangsb.filter;

import com.wangsb.annotations.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Properties;

/**
 * @author wangshenbing
 * @date 2024/01/09
 **/
public class DistrictTypeFilter extends AbstractTypeHierarchyTraversingFilter {


    /**
     * 定义路径校验的对象
     */

    private final PathMatcher pathMatcher = new AntPathMatcher();
    /**
     * 定义区域名称
     * 注意：此处的数据，应该是读取配置文件获取的。
     * 此处不能使用@Value注解读取properties配置文件的内容。
     * 因为负责填充属性值的InstantiationAwareBeanPostProcessor与TypeFilter实例创建根本不搭边。
     */
    private String districtName;

    public DistrictTypeFilter() {
        super(false, false);
        //读取配置文件（硬编码）
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
        } catch (IOException e) {
            throw new RuntimeException("Not Found district.properties file");
        }
        //给distirctName赋值
        districtName = properties.getProperty("common.district.name");
    }

    @Override
    protected boolean matchClassName(String className) {
        try {
            /**
             * 判断是否在指定包下的类（只处理和区域相关的业务类）
             */
            if (!isPotentialPackageClass(className)) {
                //不符合路径规则
                return false;
            }
            //判断当前区域和配置的区域是否一致，不一致则不能注册到Spring的Ioc容器之中
            Class<?> clazz = ClassUtils.forName(className, DistrictTypeFilter.class.getClassLoader());
            //获取District注解
            District district = clazz.getAnnotation(District.class);
            //判断是否有此注解
            if (district == null) {
                return false;
            }
            //取出注解的属性
            String districtValue = district.value();
            //校验，如果取出的value属性的值和配置文件中提供值一致，则注册到ioc容器中，返回true。否则返回false。
            return (!districtName.equalsIgnoreCase(districtValue));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 定义可以处理类的类名，指定的package下的
     */
    private static final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("com.wangsb.service.*.*");

    /**
     * 本类逻辑中可以处理的类
     *
     * @param className
     * @return
     */
    private boolean isPotentialPackageClass(String className) {
        //1.将类名转换成为资源路径，以匹配是否符合扫描条件
        String path = ClassUtils.convertClassNameToResourcePath(className);
        //2.校验
        return pathMatcher.match(PATTERN_STANDARD, path);
    }
}
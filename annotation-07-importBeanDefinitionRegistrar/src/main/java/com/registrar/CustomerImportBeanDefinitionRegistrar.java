package com.registrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;


/**
 * @author wangshenbing
 */
public class CustomerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *     定义表达式
     */

    private  String expression;

    /**
     *     使用者自定义的扫描包
     */

    private String customerPackage;

    /**
     * 默认构造函数
     * 用于给表达式赋值
     */
    public CustomerImportBeanDefinitionRegistrar(){
        try {
            Properties loadAllProperties = PropertiesLoaderUtils.loadAllProperties("CustomerImportSelector.properties");
            expression = loadAllProperties.getProperty("customer.imports-elector.expression");
            customerPackage = loadAllProperties.getProperty("customer.import-select.scan.package");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现注册bean的功能（它是通过扫描指定包实现的）
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //1.定义扫描包的集合
        List<String> basePackages = null;
        //2.判断是否有@ComponentScan注解
        if(importingClassMetadata.hasAnnotation(ComponentScan.class.getName())){
            //3.取出注解的属性
            Map<String,Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            //4.获取属性为basePackages(或者是value)
            basePackages = new ArrayList<>(Arrays.asList((String[]) attributes.get("basePackages")));
        }
        //5.判断是否有此注解，如果没有此注解时，List集合是null。如果有此注解，但是没有指定basePackages属性或者value属性是,List集合size是0
        if(basePackages == null || basePackages.size() == 0){
            //用于记录@Import注解出现类，这个类所在的包
            String basePackage = null;
            try{
                //6.取出@Import注解的类所在的包
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            }catch (Exception e){
                e.printStackTrace();
            }
            //7.添加到扫描包的集合中
            basePackages = new ArrayList<>();
            basePackages.add(basePackage);
        }

        //判断用户是否配置了扫描的包
        if(!StringUtils.isEmpty(customerPackage)){
            basePackages.add(customerPackage);
        }


        //8.创建类路径扫描器
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry,false);
        //9.创建类型过滤器
        TypeFilter typeFilter  = new AspectJTypeFilter(expression,CustomerImportBeanDefinitionRegistrar.class.getClassLoader());
        //11.把类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);
        //12.扫描指定的包
        scanner.scan(basePackages.toArray(new String[basePackages.size()]));
    }
}

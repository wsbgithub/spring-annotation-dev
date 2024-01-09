package com.wangsb.config.customer;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangshenbing
 * @date 2024/01/09
 **/
public class CustomerBeanNameGenerator implements BeanNameGenerator {
    private final Map<String, Set<String>> metaAnnotationTypesCache = new ConcurrentHashMap<>();
    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        //1、判断当前beanDefinition是否是AnnotatedBeanDefinition类型
        String beanName = null;
        if (beanDefinition instanceof AnnotatedBeanDefinition) {
            //1、获取当前beanDefinition的元数据
            AnnotationMetadata annotationMetadata = ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
            Set<String> types = annotationMetadata.getAnnotationTypes();
            for (String type : types) {
                AnnotationAttributes attributes = fromMap(annotationMetadata.getAnnotationAttributes(type));
                if (attributes != null) {
                    Set<String> metaTypes = this.metaAnnotationTypesCache.computeIfAbsent(type, key -> {
                        Set<String> result = annotationMetadata.getMetaAnnotationTypes(key);
                        return (result.isEmpty() ? Collections.emptySet() : result);
                    });
                    if (isStereotypeWithNameValue(type, metaTypes, attributes)) {
                        Object value = attributes.get("value");
                        if (value instanceof String) {
                            String strVal = (String) value;
                            if (StringUtils.hasLength(strVal)) {
                                if (beanName != null && !strVal.equals(beanName)) {
                                    throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
                                            "component names: '" + beanName + "' versus '" + strVal + "'");
                                }
                                beanName = strVal;
                            }
                        }
                    }
                }
            }
        }
        String customerBeanName = beanName != null ? beanName : "myCustomer" + buildDefaultBeanName(beanDefinition);
        System.out.println("customerBeanName = " + customerBeanName);
        return customerBeanName;
    }

    protected String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
    private  AnnotationAttributes fromMap(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        } else {
            return map instanceof AnnotationAttributes ? (AnnotationAttributes)map : new AnnotationAttributes(map);
        }
    }
    private boolean isStereotypeWithNameValue(String annotationType,
                                                Set<String> metaAnnotationTypes, @Nullable Map<String, Object> attributes) {

        boolean isStereotype = annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME) ||
                metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME) ||
                annotationType.equals("javax.annotation.ManagedBean") ||
                annotationType.equals("javax.inject.Named");

        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }
}
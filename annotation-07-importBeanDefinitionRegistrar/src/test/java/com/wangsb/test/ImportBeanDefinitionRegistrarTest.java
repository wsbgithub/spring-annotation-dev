package com.wangsb.test;

import com.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangshenbing
 * @date 2024/01/10
 **/
public class ImportBeanDefinitionRegistrarTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            /**
             * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
             * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
             * org.springframework.context.event.internalEventListenerProcessor
             * org.springframework.context.event.internalEventListenerFactory
             * springConfiguration
             * userServiceImpl
             * logUtil
             * 实例名称为类名首字母小写
             */
            System.out.println(beanDefinitionName);
        }
    }
}
package com.wangsb.test;

import com.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangshenbing
 * @date 2024/01/10
 **/
public class ImportSelectorTest {

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
             * com.wangsb.test.ImportSelectorTest
             * com.wangsb.utils.LogUtil
             * com.wangsb.service.impl.UserServiceImpl
             * 实例名称为全类名
             */
            System.out.println(beanDefinitionName);
        }
    }
}
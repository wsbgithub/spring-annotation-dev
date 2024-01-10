package com.wangsb.test;

import com.wangsb.config.JdbcConfig;
import com.wangsb.config.SpringConfig;
import com.wangsb.config.SpringImportConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author wangshenbing
 * @date 2024/01/10
 **/
public class ImportTest {

    @Test
    public void testNoImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // No qualifying bean of type 'javax.sql.DataSource' available
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }

    @Test
    public void testHasImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringImportConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }
    @Test
    public void testHasImportJdbcConfigBeanName() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringImportConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //beanDefinitionName = com.wangsb.config.JdbcConfig
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

    }
}
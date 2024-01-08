package com.wangsb.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationDrivenTest {

    /**
     * 测试
     *
     * @param args
     */
    @Test
    public void testBasePackages() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.wangsb.config");
        //2.根据id获取对象
        SpringBasePackageConfig springBasePackageConfig = ac.getBean(SpringBasePackageConfig.class);
        //springBasePackageConfig = com.wangsb.config.SpringBasePackageConfig$$EnhancerBySpringCGLIB$$afefa35b@7d900ecf
        System.out.println("springBasePackageConfig = " + springBasePackageConfig);
    }
    @Test
    public void testClass() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringClassConfig.class);
        //2.根据id获取对象
        SpringClassConfig springClassConfig = ac.getBean(SpringClassConfig.class);
        //springClassConfig = com.wangsb.config.SpringClassConfig@d21a74c
        System.out.println("springClassConfig = " + springClassConfig);
    }
}
package com.wangsb.test;

import com.wangsb.config.ComponentScanClass;
import com.wangsb.config.ComponentScanValueIsNull;
import com.wangsb.config.SpringConfiguration;
import com.wangsb.config.log.LogUtil;
import com.wangsb.service.AccountService;
import com.wangsb.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangshenbing
 * @date 2024/01/08
 **/
public class ComponentScanTest {

    @Test
    public void test_ComponentScan_isNull() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanValueIsNull.class);
        //2.根据id获取对象
        AccountService accountService = ac.getBean(AccountService.class);
        accountService.save();
    }

    @Test
    public void test_ComponentScan_isNull_log() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(LogUtil.class);
        //2.根据id获取对象
        LogUtil logUtil = ac.getBean(LogUtil.class);
        logUtil.log();
    }

    @Test
    public void test_ComponentScan_isNotNull() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取对象
        AccountService accountService = ac.getBean(AccountService.class);
        accountService.save();
    }

    @Test
    public void test_ComponentScan_class() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanClass.class);
        //2.根据id获取对象
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        UserService userService = ac.getBean(UserService.class);
        userService.delete();
    }
}
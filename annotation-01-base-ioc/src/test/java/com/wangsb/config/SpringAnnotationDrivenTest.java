package com.wangsb.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringAnnotationDrivenTest {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.wangsb.config");
        //2.根据id获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        jdbcTemplate.update("insert into account(name,money)values(?,?)","test1",123);
    }
}
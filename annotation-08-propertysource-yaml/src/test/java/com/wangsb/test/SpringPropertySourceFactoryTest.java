package com.wangsb.test;

import com.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 测试类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class SpringPropertySourceFactoryTest {

    public static void main(String[] args) throws Exception{
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        DataSource dataSource = ac.getBean("dataSource",DataSource.class);
        //3.获取连接
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}

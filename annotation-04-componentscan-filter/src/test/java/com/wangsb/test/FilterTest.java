package com.wangsb.test;

import com.wangsb.config.SpringConfiguration;
import com.wangsb.service.DistrictPercentage;
import com.wangsb.service.DistrictPerformance;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangshenbing
 * @date 2024/01/09
 **/
public class FilterTest {

    @Test
    public void testFilter() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取对象
        DistrictPercentage districtPercentage = ac.getBean(DistrictPercentage.class);
        districtPercentage.salePercentage("SUV");
        districtPercentage.salePercentage("CAR");
        DistrictPerformance districtPerformance = ac.getBean(DistrictPerformance.class);
        districtPerformance.calcPerformance("SUV");
        districtPerformance.calcPerformance("CAR");
    }
}
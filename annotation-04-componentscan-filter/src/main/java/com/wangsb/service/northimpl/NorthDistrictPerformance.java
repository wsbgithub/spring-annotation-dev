package com.wangsb.service.northimpl;

import com.wangsb.annotations.District;
import com.wangsb.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 华北区绩效计算的具体实现
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("districtPerformance")
@District("north")
public class NorthDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"绩效是3");
        }else if("CAR".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"绩效是5");
        }
    }
}

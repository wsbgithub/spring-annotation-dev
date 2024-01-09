package com.wangsb.service.southwestimpl;

import com.wangsb.annotations.District;
import com.wangsb.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 西南区绩效计算的具体实现
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("districtPerformance")
@District("southwest")
public class SouthwestDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效是5");
        }else if("CAR".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效是3");
        }
    }
}

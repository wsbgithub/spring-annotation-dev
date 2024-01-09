package com.wangsb.service.southwestimpl;

import com.wangsb.annotations.District;
import com.wangsb.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 西南区销售分成的具体实现
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("districtPercentage")
@District("southwest")
public class SouthwestDistrictPercentage implements DistrictPercentage {

    @Override
    public void salePercentage(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"提成1.5%");
        }else if("CAR".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"提成0.5%");
        }
    }
}

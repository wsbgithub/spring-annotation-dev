package com.wangsb.service.northimpl;


import com.wangsb.annotations.District;
import com.wangsb.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 华北区的销售分成具体实现
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("districtPercentage")
@District("north")
public class NorthDistrictPercentage implements DistrictPercentage {

    @Override
    public void salePercentage(String type) {

        if("SUV".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"提成1%");
        }else if("CAR".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"提成0.5%");
        }
    }
}

package com.wangsb.service;

/**
 * 销售分成的桥接接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface DistrictPercentage {

    /**
     * 不同类型的提成不同
     * 类型：
     *      CAR
     *      SUV
     * @param type
     */
    void salePercentage(String type);
}

package com.test;

/**
 * @author wangshenbing
 * @date 2024/01/10
 * <p>
 * 即使componentScan指定扫描了也是不能注入test对象的，因为才是的类型过滤器改变了 只有符合过滤器类型的才能备注如进来，
 * 所以说配置文件customer.imports-elector.expression的值是componentScan的前提条件
 **/

public class Test {
}
package com.wangsb.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于定义区域的注解
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface District {

    /**
     * 用于指定区域名称
     * @return
     */
    String value();
}

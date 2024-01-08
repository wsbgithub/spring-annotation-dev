package com.wangsb.config;

import com.wangsb.service.UserService;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangshenbing
 * @date 2024/01/08
 **/

@ComponentScan(basePackageClasses = UserService.class)
public class ComponentScanClass {
}